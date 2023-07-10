package com.example.springapp.exception;

public class InvalidDeleteException extends Exception {

    public InvalidDeleteException(String message) {
        super(message);
    }
    
    public InvalidDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
