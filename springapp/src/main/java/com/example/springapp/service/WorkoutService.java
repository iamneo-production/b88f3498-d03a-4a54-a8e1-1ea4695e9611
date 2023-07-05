package com.example.springapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Workout;
import com.example.springapp.service.WorkoutServiceInterface;


@Service
public class WorkoutService implements WorkoutServiceInterface{
    @Override
    public List<Workout> getAllWorkout(){
        return null;

    }
    @Override
     public Workout getWorkoutById(long id){
        return null;
     }
     @Override
     public List<Workout> getWorkOutByUserId(long user_id){
        return null;
        
     } 
    
}
package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.exceptions.UserNotFoundException;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.WorkoutRepository;

@Service
public class WorkoutService extends RuntimeException implements WorkoutServiceInterface {
   @Autowired
   private WorkoutRepository workoutRepository;

    @Override
    public List<Workout> getAllWorkout(){
        return null;

    }
     @Override
     public Workout getWorkoutById(long id){
        Optional<Workout> optionalworkout = workoutRepository.findWorkoutById(id);
        return optionalworkout.orElseThrow(() -> new UserNotFoundException("User is not present in Databse"));
     }
     
     @Override
     public List<Workout> getWorkOutByUserId(long userId){
        return workoutRepository.findAllByUserId(userId);
     }
}
