package com.example.springapp.service;
import java.util.List;
import com.example.springapp.model.Exercise;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;


public interface ExerciseServiceInterface {
    public Iterable<Exercise> getAllExercise();
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException;
    public void deleteExerciseById(long id) throws InvalidDeleteException;
    public List<Exercise> getExerciseByWorkoutId(long workoutId) throws WorkoutNotFoundException;

    
}
