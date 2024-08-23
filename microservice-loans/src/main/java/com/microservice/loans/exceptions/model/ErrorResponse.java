package com.microservice.loans.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String error;
    private int status;
    private String message;
    private String timestamp;

}
