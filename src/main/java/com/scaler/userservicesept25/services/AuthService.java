package com.scaler.userservicesept25.services;

import com.scaler.userservicesept25.models.User;
import org.antlr.v4.runtime.misc.Pair;

public interface AuthService {
    User signup(String name, String email, String password, String phoneNumber);

    Pair<User, String> login(String email, String password);
}
