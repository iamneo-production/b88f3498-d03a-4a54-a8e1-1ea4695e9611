package com.example.springapp.repository;

import java.util.*;

import org.springframework.data.repository.CrudRepository;


import com.example.springapp.model.Workout;


public interface WorkoutRepository extends CrudRepository<Workout, Long> {


    Optional<Workout> findWorkoutById(long id);
    List<Workout> findAllByUserId(long id);

}
