package com.codewitharjun.fullstackbackend.exception;
/* Created by Arjun Gautam */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // global exception handler for whole app
public class UserNotFoundAdvice {

    @ResponseBody // return JSON instead of view
    @ExceptionHandler(UserNotFoundException.class) // catch this exception
    @ResponseStatus(HttpStatus.NOT_FOUND) // send 404 status
    public Map<String,String> exceptionHandler(UserNotFoundException exception){

        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage()); // error message

        return errorMap; // return JSON
    }
}
