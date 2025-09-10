package com.scaler.userservicesept25.services;

import com.scaler.userservicesept25.exceptions.PasswordNotMatchedException;
import com.scaler.userservicesept25.exceptions.UserAlreadyPresentException;
import com.scaler.userservicesept25.exceptions.UserNotPresentException;
import com.scaler.userservicesept25.models.User;
import com.scaler.userservicesept25.repositories.RoleRepository;
import com.scaler.userservicesept25.repositories.UserRespository;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userAuthService")
public class UserAuthService implements AuthService {

    private final UserRespository userRespository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAuthService(UserRespository userRespository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRespository = userRespository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    public Pair<User, String> login(String email, String password) {
        Optional<User> userOptional = userRespository.findByEmailEquals(email);
        if (userOptional.isEmpty()) {
            throw new UserNotPresentException("User not present with email: " + email);
        }

        if (!bCryptPasswordEncoder.matches(password, userOptional.get().getPassword())) {
            throw new PasswordNotMatchedException("Password not matched for email: " + email);
        }

        //To do : Generate JWT token and return it
        return new Pair<>(userOptional.get(), "token");
    }

}
