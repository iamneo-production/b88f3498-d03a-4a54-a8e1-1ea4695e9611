package com.example.springapp.service;
import java.util.List;
import com.example.springapp.model.Exercise;
import org.springframework.http.ResponseEntity;


import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.CustomDataAccessException;

public interface ExerciseServiceInterface {
    public Iterable<Exercise> getAllExercise() throws CustomDataAccessException;

    public Exercise getExerciseById(long id) throws ExerciseNotFoundException;

    ResponseEntity<String> deleteExerciseById(long id) throws InvalidDeleteException;

    public List<Exercise> getExerciseByWorkoutId(long workoutId) throws WorkoutNotFoundException;

    

    
}
