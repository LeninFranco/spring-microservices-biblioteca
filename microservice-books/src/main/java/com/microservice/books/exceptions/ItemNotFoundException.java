package com.microservice.books.exceptions;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message){
        super(message);
    }

}
