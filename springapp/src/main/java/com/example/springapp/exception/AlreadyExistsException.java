package com.example.springapp.exception;

public class AlreadyExistsException extends Exception{
    public AlreadyExistsException(String message){
        super(message);
    }
}
