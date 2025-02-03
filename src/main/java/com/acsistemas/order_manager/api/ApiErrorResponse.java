package com.acsistemas.order_manager.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Data
public class ApiErrorResponse {
    List<String> errors;
    int status;
    String statusName;
    LocalDateTime timestamp;

    public ApiErrorResponse(String error, HttpStatus status) {
        this.errors = Collections.singletonList(error);
        this.status = status.value();
        this.statusName = status.name();
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponse(String error) {
        this.errors = Collections.singletonList(error);
        this.status = HttpStatus.BAD_REQUEST.value();
        this.statusName = HttpStatus.BAD_REQUEST.name();
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponse(List<String> errors, HttpStatus status) {
        this.errors = errors;
        this.status = status.value();
        this.statusName = status.name();
        this.timestamp = LocalDateTime.now();
    }

    public ApiErrorResponse(List<String> errors) {
        this.errors = errors;
        this.status = HttpStatus.BAD_REQUEST.value();
        this.statusName = HttpStatus.BAD_REQUEST.name();
        this.timestamp = LocalDateTime.now();
    }
}
