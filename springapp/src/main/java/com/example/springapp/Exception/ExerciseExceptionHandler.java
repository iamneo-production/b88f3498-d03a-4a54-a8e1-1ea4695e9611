package com.example.springapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExerciseExceptionHandler {

    @ExceptionHandler(value = {ExerciseNotFoundException.class})
    public ResponseEntity<ExerciseExceptions> exerciseNotFoundExceptionHandler(ExerciseNotFoundException exerciseNotFoundException){
        ExerciseExceptions exerciseException = new ExerciseException(exerciseNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        ResponseEntity<ExerciseExceptions> responseEntity = new ResponseEntity<ExerciseExceptions>(exerciseException, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    
}
