package com.example.springapp.exception;

public class UserNotFoundException extends RuntimeException {

   public UserNotFoundException(){
    super();
   }
   public UserNotFoundException(String message){
    super(message);
   }
    

}
