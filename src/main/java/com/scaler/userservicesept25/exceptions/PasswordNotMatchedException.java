package com.scaler.userservicesept25.exceptions;

public class PasswordNotMatchedException extends RuntimeException {
    public PasswordNotMatchedException(String message) {
        super(message);
    }
}
