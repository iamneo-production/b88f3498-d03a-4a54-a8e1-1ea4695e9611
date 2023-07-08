package com.example.springapp.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.springapp.model.Workout;
import com.example.springapp.exception.WorkoutNotFoundException;

import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.UserNotFoundException;

public interface WorkoutServiceInterface {
     public Iterable<Workout> getAllWorkout();
     public Workout getWorkoutById(long id) throws WorkoutNotFoundException;
     public List<Workout> getWorkOutByUserId(long user_id) throws UserNotFoundException;
     public List<Workout> getWorkOutByUserId(long user_id); 
}
