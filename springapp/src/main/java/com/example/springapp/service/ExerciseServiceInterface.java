package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Exercise;

public interface ExerciseServiceInterface {
    public List<Exercise> getAllExercise();
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException;
    public List<Exercise> getExerciseByWorkoutId(long w_id) throws ExerciseNotFoundException;
    
}
