package com.example.springapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springapp.exception.ExceptionProperties;
import com.example.springapp.exception.ExerciseNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ExerciseNotFoundException.class})
    public ResponseEntity<ExceptionProperties> exerciseNotFoundExceptionHandler(ExerciseNotFoundException exerciseNotFoundException){
        ExceptionProperties exceptionProperties = new ExceptionProperties(exerciseNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {SetsNotFoundException.class})
    public ResponseEntity<ExceptionProperties> setNotFoundExceptionHandler(SetsNotFoundException setsNotFoundException){
        ExceptionProperties exceptionProperties = new ExceptionProperties(setsNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {WorkoutNotFoundException.class})
    public ResponseEntity<ExceptionProperties> setNotFoundExceptionHandler(WorkoutNotFoundException workoutNotFoundException){
        ExceptionProperties exceptionProperties = new ExceptionProperties(workoutNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.NOT_FOUND);
    }
    
}
