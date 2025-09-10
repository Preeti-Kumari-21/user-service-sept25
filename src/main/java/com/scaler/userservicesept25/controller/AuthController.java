package com.scaler.userservicesept25.controller;

import com.scaler.userservicesept25.dto.LoginRequestDto;
import com.scaler.userservicesept25.dto.SignupRequestDto;
import com.scaler.userservicesept25.dto.UserDto;
import com.scaler.userservicesept25.models.Token;
import com.scaler.userservicesept25.models.User;
import com.scaler.userservicesept25.services.AuthService;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // http://localhost:8082/auth
public class AuthController {

    private final AuthService authService;

    public AuthController(@Qualifier("userAuthService") AuthService authService) {
        this.authService = authService;
    }

    //signup API
    @PostMapping("/signup")// http://localhost:8082/auth/signup
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        User user = authService.signup(signupRequestDto.getName(), signupRequestDto.getEmail(), signupRequestDto.getPassword(), signupRequestDto.getPhoneNumber());
        return convertUserToUserDto(user);
    }

    //login API
    @PostMapping("/login")// http://localhost:8082/auth/login
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        Token userWithToken = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        return new ResponseEntity<>(userWithToken.getValue(), HttpStatus.OK);
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    //token is passed in url
    @GetMapping("/validate/{tokenValue}") // http://localhost:8082/auth/validate/{tokenValue}
    public UserDto validateToken(@PathVariable("tokenValue") String tokenValue){
        User user = authService.validateToken(tokenValue);
        return convertUserToUserDto(user);
    }

    //Passing token in header

    @GetMapping("/validateInHeader")
    public UserDto validateTokenInHeader(@RequestHeader("token") String tokenValue){
        User user = authService.validateToken(tokenValue);
        return convertUserToUserDto(user);
    }
}
