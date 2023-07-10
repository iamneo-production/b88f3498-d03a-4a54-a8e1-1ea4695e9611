package com.example.springapp.service;
import java.util.List;
import com.example.springapp.model.Exercise;
import org.springframework.http.ResponseEntity;


import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidUpdateException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.CustomDataAccessException;
import com.example.springapp.exception.InvalidUpdateException;

public interface ExerciseServiceInterface {
    
     Iterable<Exercise> getAllExercise() throws CustomDataAccessException;

    Exercise getExerciseById(long id) throws ExerciseNotFoundException;

    ResponseEntity<String> deleteExerciseById(long id) throws InvalidDeleteException;


    List<Exercise> getExerciseByWorkoutId(long workoutId) throws WorkoutNotFoundException;

    ResponseEntity<String> updateExercise(Exercise exercise) throws InvalidUpdateException;

    ResponseEntity<String> createExercise(Exercise exercise) throws AlreadyExistsException;
    

    
}
