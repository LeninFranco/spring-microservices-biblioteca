package com.microservice.books.exceptions.handler;

import com.microservice.books.exceptions.ItemNotFoundException;
import com.microservice.books.exceptions.model.ErrorResponse;
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
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
