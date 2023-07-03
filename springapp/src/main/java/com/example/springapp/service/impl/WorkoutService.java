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
