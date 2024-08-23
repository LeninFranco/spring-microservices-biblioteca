package com.microservice.loans.exceptions.handler;

import com.microservice.loans.exceptions.ItemNotFoundException;
import com.microservice.loans.exceptions.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleItemNotFoundException(ItemNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(
                "Item Not Found",
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) // Cambiado a LocalDateTime
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
