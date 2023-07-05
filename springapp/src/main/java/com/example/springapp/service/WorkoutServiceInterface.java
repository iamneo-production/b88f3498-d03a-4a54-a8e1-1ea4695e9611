package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Workout;

public interface WorkoutServiceInterface {
     public List<Workout> getAllWorkout();
     public Workout getWorkoutById(long id);
     public List<Workout> getWorkOutByUserId(long user_id);
     public ResponseEntity<String> addOrUpdateWorkout(Workout workout,String message);
     public ResponseEntity<String> deleteFromWorkout(long id);

}
