package com.example.springapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springapp.springapp.model.Set;
import springapp.springapp.model.User;
import springapp.springapp.model.Workout;
import springapp.springapp.repository.UserRepository;
import springapp.springapp.repository.WorkoutRepository;
@RestController
@CrossOrigin
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    //  @GetMapping("/id")
    //  public Workout getWorkoutById(long id){
    //      Workout optionalWorkout;
    //      try{
    //          optionalWorkout = workoutRepository.getWorkoutById(id);
    //      }catch(Exception e){
    //          return null;
    //      }
    //  return optionalWorkout;
    //  }

    // @GetMapping("/userId")
    // public Workout getWorkOutByUserId(long id)
   
    // @PostMapping
    // public ResponseEntity<String> createWorkout(@RequestBody Workout workout,@RequestParam("uid") long user_id) {
    //     System.out.println(workout);
    //     User newUser = new User();
    //     newUser.setId(user_id);
    //     workout.setUser(newUser);
    //     Workout createdWorkout = workoutRepository.save(workout);
    //     if (createdWorkout != null) {
    //         return ResponseEntity.ok(workout.toString());
    //     } else {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }
     
    @GetMapping
    public ResponseEntity<Iterable<Workout>> getAllWorkouts() {
        Iterable<Workout> workouts = workoutRepository.findAll();
        return ResponseEntity.ok(workouts);
    }

    

}


