package com.scaler.userservicesept25.controller;

import com.scaler.userservicesept25.dto.LoginRequestDto;
import com.scaler.userservicesept25.dto.SignupRequestDto;
import com.scaler.userservicesept25.dto.UserDto;
import com.scaler.userservicesept25.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // http://localhost:8082/auth
public class AuthController {

    //signup API
    @PostMapping
    @GetMapping("/signup") // http://localhost:8082/auth/signup
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return new UserDto();
    }

    //login API
    @PostMapping
    @GetMapping("/login") // http://localhost:8082/auth/login
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(new UserDto());
    }
}
