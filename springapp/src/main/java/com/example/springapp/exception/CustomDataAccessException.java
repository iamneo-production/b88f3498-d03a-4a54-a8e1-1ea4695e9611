package com.example.springapp.exception;

public class CustomDataAccessException extends Exception {
    
    public CustomDataAccessException(String message) {
        super(message);
    } 
    public CustomDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}

    

