package com.app.infrastructure.security.exceptions;

public class JwtAuthenticationFilterException extends RuntimeException {
    public JwtAuthenticationFilterException(String message) {
        super(message);
    }
}
