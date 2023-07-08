package com.example.springapp.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.springapp.model.Workout;

public interface WorkoutServiceInterface {
     public Iterable<Workout> getAllWorkout();
     public Workout getWorkoutById(long id) throws WorkoutNotFoundException;
     public List<Workout> getWorkOutByUserId(long user_id) throws UserNotFoundException; 
}
