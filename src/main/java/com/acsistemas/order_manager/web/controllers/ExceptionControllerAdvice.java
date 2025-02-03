package com.acsistemas.order_manager.web.controllers;

import com.acsistemas.order_manager.api.ApiErrorResponse;
import com.acsistemas.order_manager.api.exceptions.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handlerValidationException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException exception) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorResponse);
    }
}
