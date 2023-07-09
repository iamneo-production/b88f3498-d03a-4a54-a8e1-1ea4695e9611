package com.example.springapp.exception;

public class WorkoutNotFoundException extends Exception {

    public WorkoutNotFoundException(String message){
        super(message);
    }
    
}