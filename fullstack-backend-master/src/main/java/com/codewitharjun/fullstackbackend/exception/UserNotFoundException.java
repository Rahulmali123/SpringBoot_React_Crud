package com.codewitharjun.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // HTTP 404
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("Could not find user with id " + id); // clean message
    }
}