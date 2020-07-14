package com.app.infrastructure.controller;

import com.app.application.service.SecurityServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(SecurityServiceException.class)
    public String handleSecurityServiceException(SecurityServiceException securityServiceException) {
        return "SECURITY SERVICE EXCEPTION: " + securityServiceException.getMessage();
    }

}
