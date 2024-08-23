package com.microservice.loans.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message){
        super(message);
    }

}
