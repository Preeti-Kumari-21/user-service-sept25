package com.scaler.userservicesept25.services;

import com.scaler.userservicesept25.exceptions.InvalidTokenException;
import com.scaler.userservicesept25.exceptions.PasswordNotMatchedException;
import com.scaler.userservicesept25.exceptions.UserAlreadyPresentException;
import com.scaler.userservicesept25.exceptions.UserNotPresentException;
import com.scaler.userservicesept25.models.Token;
import com.scaler.userservicesept25.models.User;
import com.scaler.userservicesept25.repositories.RoleRepository;
import com.scaler.userservicesept25.repositories.TokenRespository;
import com.scaler.userservicesept25.repositories.UserRespository;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service("userAuthService")
public class UserAuthService implements AuthService {

    private final UserRespository userRespository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final TokenRespository tokenRespository;


    public UserAuthService(UserRespository userRespository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TokenRespository tokenRespository) {
        this.userRespository = userRespository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRespository = tokenRespository;
    }

    @Override
    public User signup(String name, String email, String password, String phoneNumber) {
        Optional<User> userOptional = userRespository.findByEmailEquals(email);
        if (userOptional.isPresent()) {
            throw new UserAlreadyPresentException("User already present with email: " + email);
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        //user.setPassword(password); //Here we will user Bcrypt to store the password
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setPhoneNumber(phoneNumber);
        return userRespository.save(user);
    }

    @Override
    public Token login(String email, String password) {
        Optional<User> userOptional = userRespository.findByEmailEquals(email);
        if (userOptional.isEmpty()) {
            throw new UserNotPresentException("User not present with email: " + email);
        }

        if (!bCryptPasswordEncoder.matches(password, userOptional.get().getPassword())) {
            throw new PasswordNotMatchedException("Password not matched for email: " + email);
        }

        //To do : Generate JWT token and return it
        //Once the login is successful we will generate a token and save it in DB then return token
        Token token = new Token();

        token.setUser(userOptional.get());

        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date expiryDate = calendar.getTime();
        token.setExpiryDate(expiryDate);// TODO: set expiry date

        tokenRespository.save(token);
        return token;
    }

    @Override
    public User validateToken(String tokenValue) {
        Optional<Token> optionalToken = tokenRespository.findByValueAndExpiryDateAfter(tokenValue, new Date());

        if(optionalToken.isEmpty()) {
            throw new InvalidTokenException("Invalid token");
        }

        return optionalToken.get().getUser();
    }


}
