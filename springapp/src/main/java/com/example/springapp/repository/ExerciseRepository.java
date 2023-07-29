package com.example.springapp.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.Exercise;


public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    
    Optional<Exercise> findExerciseById(long id);

    Exercise deleteExerciseById(long id);

    List<Exercise> findAllByWorkoutId(long workoutId);

    Optional<Exercise> findByWorkoutId(long workoutId);

    Iterable<Exercise> findAll();

    Exercise save(Exercise exercise);
    
}
