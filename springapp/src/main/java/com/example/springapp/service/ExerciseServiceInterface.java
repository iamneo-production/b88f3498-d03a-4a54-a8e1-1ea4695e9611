package com.example.springapp.service;
import java.util.List;
import com.example.springapp.model.Exercise;
import com.example.springapp.exception.ExerciseNotFoundException;

public interface ExerciseServiceInterface {
    public Iterable<Exercise> getAllExercise();
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException;
    public void deleteExerciseById(long id);
    public List<Exercise> getExerciseByWorkoutId(long workoutId);

    
}
