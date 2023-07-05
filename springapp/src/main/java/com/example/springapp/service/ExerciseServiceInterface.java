package com.example.springapp.service;

<<<<<<< HEAD
import java.util.List;

import com.example.springapp.model.Exercise;

public interface ExerciseServiceInterface {
    public List<Exercise> getAllExercise();
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException;
    public List<Exercise> getExerciseByWorkoutId(long w_id) throws ExerciseNotFoundException;
=======

import java.util.List;
import com.example.springapp.model.Exercise;

public interface ExerciseServiceInterface {
    public Iterable<Exercise> getAllExercise();
    public Exercise getExerciseById(long id);
    public void deleteExerciseById(long id);
    public List<Exercise> getExerciseByWorkoutId(long workoutId);
>>>>>>> 0f7aca6afa9e6b43818a1829a09ebc0b896c73ad
    
}
