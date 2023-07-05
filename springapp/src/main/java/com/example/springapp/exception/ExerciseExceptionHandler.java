package com.example.springapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.springapp.exception.ExerciseException;
import com.example.springapp.exception.ExerciseNotFoundException;

@ControllerAdvice
public class ExerciseExceptionHandler {

    @ExceptionHandler(value = {ExerciseNotFoundException.class})
    public ResponseEntity<ExerciseException> exerciseNotFoundExceptionHandler(ExerciseNotFoundException exerciseNotFoundException){
        ExerciseException exerciseException = new ExerciseException(exerciseNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exerciseException, HttpStatus.NOT_FOUND);
    }
    
}
