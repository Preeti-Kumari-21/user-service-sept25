package com.scaler.userservicesept25.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        try {
            http
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()
                    )
                    .cors().disable()
                    .csrf().disable();

            return http.build();
        } catch (Exception e) {
            throw new RuntimeException("Failed to configure SecurityFilterChain", e);
        }
    }
}
