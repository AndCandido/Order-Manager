package com.acsistemas.order_manager.web.controllers;

import com.acsistemas.order_manager.api.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handlerValidationException(MethodArgumentNotValidException exception) {
        return exception.getAllErrors().stream().map(ex -> ex.getDefaultMessage()).toList();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handlerResourceNotFoundException(ResourceNotFoundException exception) {
        return exception.getMessage();
    }
}
