package com.scaler.userservicesept25.controller;

import com.scaler.userservicesept25.dto.LoginRequestDto;
import com.scaler.userservicesept25.dto.SignupRequestDto;
import com.scaler.userservicesept25.dto.UserDto;
import com.scaler.userservicesept25.models.User;
import com.scaler.userservicesept25.services.AuthService;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        Pair<User, String> userWithToken = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        UserDto userDto = convertUserToUserDto(userWithToken.a);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
