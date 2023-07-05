package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.model.User;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.WorkoutRepository;


@Service
public class WorkoutService extends RuntimeException implements WorkoutServiceInterface{
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
   @Override
   public ResponseEntity<String> addOrUpdateWorkout(Workout workout,String message) {
      long userId = workout.getUser().getId();
        User newUser = new User();
        newUser.setId(userId);
        workout.setUser(newUser);
        Workout createdWorkout = workoutRepository.save(workout);
        if (createdWorkout != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   } 

   @Override
   public ResponseEntity<String> deleteFromWorkout(long id){
      workoutRepository.deleteById(id);
      if(workoutRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }else{
         return ResponseEntity.ok("Workout Deleted");
      }
   }
   
}

