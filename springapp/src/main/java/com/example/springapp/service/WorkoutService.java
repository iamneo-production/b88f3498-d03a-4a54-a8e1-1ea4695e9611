package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.exceptions.UserNotFoundException;
import com.example.springapp.model.User;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.WorkoutRepository;

@Service
public class WorkoutService extends RuntimeException implements WorkoutServiceInterface {
   @Autowired
   private WorkoutRepository workoutRepository;

    @Override
    public Iterable<Workout> getAllWorkout(){
        return  workoutRepository.findAll();

    }
     @Override
     public Workout getWorkoutById(long id){
        Optional<Workout> optionalworkout = workoutRepository.findWorkoutById(id);
        return optionalworkout.orElseThrow(() -> new UserNotFoundException("User not Found"));
     }
     
     @Override
     public List<Workout> getWorkOutByUserId(long userId){
        return workoutRepository.findAllByUserId(userId);
     }
   public ResponseEntity<String> createWorkout(Workout workout) {
      long userId = workout.getUser().getId();
        User newUser = new User();
        newUser.setId(userId);
        workout.setUser(newUser);
        Workout createdWorkout = workoutRepository.save(workout);
        if (createdWorkout != null) {
            return ResponseEntity.ok("Workout Created");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   }
   public ResponseEntity<String> updateWorkout(Workout workout) {
      long userId = workout.getUser().getId();
        User newUser = new User();
        newUser.setId(userId);
        workout.setUser(newUser);
        Workout createdWorkout = workoutRepository.save(workout);
        if (createdWorkout != null) {
            return ResponseEntity.ok("workout Updated");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   }

   
   public ResponseEntity<String> deleteWorkoutById(long id) {
      workoutRepository.deleteById(id);
      return new ResponseEntity<>("workout deleted", HttpStatus.OK);
   }
   
}
