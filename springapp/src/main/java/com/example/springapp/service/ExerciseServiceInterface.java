package com.example.springapp.service;

import com.example.springapp.model.Exercise;

public interface ExerciseServiceInterface {
    public Iterable<Exercise> getAllExercise();
    public Exercise getExerciseById(long id);
    public Iterable<Exercise> getExerciseByWorkoutId(long w_id);
    
}
