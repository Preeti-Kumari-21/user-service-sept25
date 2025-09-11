package com.scaler.userservicesept25.security;

import com.scaler.userservicesept25.models.User;
import com.scaler.userservicesept25.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRespository.findByEmailEquals(username);

        if(optionalUser.isEmpty()){
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserDetails(optionalUser.get());
    }
}
