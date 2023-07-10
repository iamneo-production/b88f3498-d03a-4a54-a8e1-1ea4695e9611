package com.example.springapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springapp.exception.ExceptionProperties;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.InvalidInputException;
import com.example.springapp.exception.InvalidUpdateException;

import com.example.springapp.exception.InvalidDeleteException;

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
    
    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<ExceptionProperties> setNotFoundExceptionHandler(AlreadyExistsException alreadyExistsException){
        ExceptionProperties exceptionProperties = new ExceptionProperties(alreadyExistsException.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {InvalidInputException.class}) 
    public ResponseEntity<ExceptionProperties> invalidInputExceptionHandler(InvalidInputException invalidInputException) {
        ExceptionProperties exceptionProperties = new ExceptionProperties(invalidInputException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = {InvalidDeleteException.class})
    public ResponseEntity<ExceptionProperties> invalidDeleteExceptionHandler(InvalidDeleteException invalidDeleteException){
        ExceptionProperties exceptionProperties = new ExceptionProperties(invalidDeleteException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = {InvalidUpdateException.class}) 
    public ResponseEntity<ExceptionProperties> invalidUpdateExceptionHandler(InvalidUpdateException invalidUpdateException) {
        ExceptionProperties exceptionProperties = new ExceptionProperties(invalidUpdateException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DeleteSetException.class}) 
    public ResponseEntity<ExceptionProperties> deleteSetExceptionHandler(DeleteSetException deleteSetException) {
        ExceptionProperties exceptionProperties = new ExceptionProperties(deleteSetException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionProperties, HttpStatus.BAD_REQUEST);
    }
    


    
}
