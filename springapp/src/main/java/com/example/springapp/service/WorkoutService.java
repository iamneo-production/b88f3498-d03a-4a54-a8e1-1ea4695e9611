package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.model.User;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.WorkoutRepository;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidInputException;
import com.example.springapp.exception.CustomDataAccessException;

@Service
public class WorkoutService extends RuntimeException implements WorkoutServiceInterface {
  
    @Autowired
   private WorkoutRepository workoutRepository;

   @Override
   public Iterable<Workout> getAllWorkout() throws CustomDataAccessException{
       try {
           return workoutRepository.findAll();
       } catch (Exception e) {
           throw new CustomDataAccessException("Error occurred while retrieving all workouts", e);
       }
   }
     @Override
     public Workout getWorkoutById(long id) throws WorkoutNotFoundException{
        Optional<Workout> optionalworkout = workoutRepository.findWorkoutById(id);
        if(optionalworkout.isEmpty()){
            throw new WorkoutNotFoundException("Workout does not exists for Particular ID");
        }
        return optionalworkout.get();
     }
     
     @Override
     public List<Workout> getWorkOutByUserId(long userId) throws UserNotFoundException{
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
   @Override
   public ResponseEntity<String> updateWorkout(Workout workout)  throws InvalidInputException {
            if (workout == null || workout.getUser() == null || workout.getUser().getId() <= 0) {
            throw new InvalidInputException("Invalid input provided for updating the workout.");
        }
            long userId = workout.getUser().getId();
            User newUser = new User();
            newUser.setId(userId);
            workout.setUser(newUser);
            Workout createdWorkout;
            try{
                createdWorkout = workoutRepository.save(workout);
            }catch (Exception e) {
                throw new InvalidInputException("Error occurred while updating the workout.");
            }
        if(createdWorkout != null) {
                return ResponseEntity.ok("workout Updated");
            } 
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    }

   @Override
   public ResponseEntity<String> deleteWorkoutById(long id) throws InvalidDeleteException {
    try {
        workoutRepository.deleteById(id);
        return new ResponseEntity<>("Workout deleted", HttpStatus.OK);
    } catch (Exception e) {
        throw new InvalidDeleteException("Error occurred while deleting the workout.");
    }
}
   
}
