package com.scaler.userservicesept25.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scaler.userservicesept25.models.Token;
import com.scaler.userservicesept25.models.User;
import org.antlr.v4.runtime.misc.Pair;

public interface AuthService {
    User signup(String name, String email, String password, String phoneNumber) throws JsonProcessingException;

    Token login(String email, String password);

    User validateToken(String tokenValue);
}
