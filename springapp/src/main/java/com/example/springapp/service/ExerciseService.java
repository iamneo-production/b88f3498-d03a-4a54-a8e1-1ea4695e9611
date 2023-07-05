package com.example.springapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.springapp.model.Exercise;
import com.example.springapp.repository.ExerciseRepository;

@Service 
public class ExerciseService extends RuntimeException implements ExerciseServiceInterface {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Iterable<Exercise> getAllExercise(){
        return exerciseRepository.findAll();

    }
    
    @Override
     public Exercise getExerciseById(long id){
        Optional<Exercise> optionalExercise = exerciseRepository.findExerciseById(id);
        return optionalExercise.orElseThrow();
     }
     @Override
     public List<Exercise> getExerciseByWorkoutId(long workoutId){
        return null;
        
     } 
    @Override
    public void deleteExerciseById(long id){
         exerciseRepository.deleteExerciseById(id);
    }
    
        
     
    
}
