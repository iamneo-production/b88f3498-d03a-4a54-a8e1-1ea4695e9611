package com.example.springapp.service;


import java.util.List;
import com.example.springapp.model.Exercise;

public interface ExerciseServiceInterface {
    public Iterable<Exercise> getAllExercise();
    public Exercise getExerciseById(long id);
    public void deleteExerciseById(long id);
    public List<Exercise> getExerciseByWorkoutId(long workoutId);
    
}
