package com.example.springapp.exception;

import org.springframework.http.HttpStatus;


public class ExerciseExceptions {

    private String message;
    private HttpStatus httpstatus;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public HttpStatus getHttpstatus() {
        return httpstatus;
    }
    public void setHttpstatus(HttpStatus httpstatus) {
        this.httpstatus = httpstatus;
    }
    public ExerciseException(String message, HttpStatus httpstatus) {
        this.message = message;
        this.httpstatus = httpstatus;
    }
    
    
}
