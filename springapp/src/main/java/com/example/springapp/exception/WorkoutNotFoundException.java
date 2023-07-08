package com.example.springapp.exception;

public class WorkoutNotFoundException extends Exception {

    public WorkoutNotFoundException(String message){
        super(message);
    }
    
}
public class InvalidInputException extends Exception {

    public InvalidInputException(String message) {
        super(message);
    }
}
