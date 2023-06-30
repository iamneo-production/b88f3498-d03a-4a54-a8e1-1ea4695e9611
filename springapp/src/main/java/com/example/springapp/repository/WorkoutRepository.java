package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.Workout;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

    Workout getWorkoutById(long id);
    
}
