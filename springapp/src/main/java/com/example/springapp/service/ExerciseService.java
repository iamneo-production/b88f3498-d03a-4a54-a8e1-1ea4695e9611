package com.example.springapp.service.impl;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.repository.ExerciseRepository;
import com.example.springapp.model.Exercise;

@Service
public class ExerciseService implements ExerciseServiceInterface{

=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.springapp.model.Exercise;
import com.example.springapp.repository.ExerciseRepository;

@Service 
public class ExerciseService extends RuntimeException implements ExerciseServiceInterface {
>>>>>>> 0f7aca6afa9e6b43818a1829a09ebc0b896c73ad
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
<<<<<<< HEAD
    public List<Exercise> getAllExercise(){
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException{
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if(!exercise.isPresent()){
            throw new ExerciseNotFoundException("Exercise not found for the particular id");
        }
        return exerciseRepository.findById(id).get();
    }

    @Override
    public List<Exercise> getExerciseByWorkoutId(long w_id) throws ExerciseNotFoundException{
        List<Exercise> exercises = exerciseRepository.findByWorkoutId(w_id);
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("Exercise not found for the particular workout id");
        }
        return exercises;
    }
}
=======
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
>>>>>>> 0f7aca6afa9e6b43818a1829a09ebc0b896c73ad
