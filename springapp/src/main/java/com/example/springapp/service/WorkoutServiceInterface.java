package com.example.springapp.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.example.springapp.model.Workout;

import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.InvalidInputException;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.CustomDataAccessException;

public interface WorkoutServiceInterface {
     public Iterable<Workout> getAllWorkout() throws CustomDataAccessException;
     public Workout getWorkoutById(long id) throws WorkoutNotFoundException;
     public List<Workout> getWorkOutByUserId(long user_id) throws UserNotFoundException;
     ResponseEntity<String> updateWorkout(Workout workout) throws InvalidInputException;
     ResponseEntity<String> deleteWorkoutById(long id) throws InvalidDeleteException;
}
