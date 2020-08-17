package com.example.rest.error;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User id not found : " + id);
    }
    
}
