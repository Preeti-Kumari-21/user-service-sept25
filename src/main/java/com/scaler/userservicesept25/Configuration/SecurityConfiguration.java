package com.scaler.userservicesept25.Configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {

/*    @Bean
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
    }*/
}
