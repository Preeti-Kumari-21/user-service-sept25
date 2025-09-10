package com.scaler.userservicesept25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UserServiceSept25Application {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceSept25Application.class, args);
    }

}
