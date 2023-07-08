package com.example.springapp.exception;

public class WorkoutNotFoundException extends Exception {

    WorkoutNotFoundException(String message){
        super(message);
    }
    
}
