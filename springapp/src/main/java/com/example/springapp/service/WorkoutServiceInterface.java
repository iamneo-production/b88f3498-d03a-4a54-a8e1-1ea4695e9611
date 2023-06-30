package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Workout;

public interface WorkoutServiceInterface {
     public List<Workout> getAllWorkout();
     public Workout getWorkoutById(long id);
     public Iterable<Workout> getWorkOutByUserId(long user_id); 
}
