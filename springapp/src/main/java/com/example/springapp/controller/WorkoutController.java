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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


import com.example.springapp.model.User;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.UserRepository;
import com.example.springapp.service.WorkoutService;
import com.example.springapp.repository.WorkoutRepository;
@RestController
@RequestMapping("/workout")
@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;
   
    /**
     * @param workout
     * @return
     */
    @PostMapping
    public ResponseEntity<String> createWorkout(@RequestBody Workout workout) {
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
     
    @GetMapping
    public ResponseEntity<Iterable<Workout>> getAllWorkouts() {
        Iterable<Workout> workouts = workoutRepository.findAll();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/id")
    public Workout getWorkoutById(@RequestParam("id") long id){
        return workoutService.getWorkoutById(id);
    }
    
    @GetMapping("/userid")
    public List<Workout> getWorkoutByUserId(@RequestParam("userid") long id){
        return workoutService.getWorkOutByUserId(id);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateWorkout(@RequestBody Workout workout) {
        long userId = workout.getUser().getId();
        User newUser = new User();
        newUser.setId(userId);
        workout.setUser(newUser);
        Workout createdWorkout = workoutRepository.save(workout);
        if (createdWorkout != null) {
            return ResponseEntity.ok("Workout Updated");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


