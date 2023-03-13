package com.wowcher.clock.exception;

import com.wowcher.clock.dto.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomErrorResponse error = new CustomErrorResponse("BAD_REQUEST", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(Exception e) {
        CustomErrorResponse error = new CustomErrorResponse("INTERNAL_SERVER_ERROR", e.getMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
}
