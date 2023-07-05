package com.example.springapp.controller;


import java.util.ArrayList;
import java.util.HashMap;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springapp.springapp.model.Set;
import springapp.springapp.model.User;
import springapp.springapp.model.Workout;
import springapp.springapp.repository.UserRepository;
import springapp.springapp.repository.WorkoutRepository;
import springapp.springapp.service.impl.WorkoutService;

@RestController
@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;
    
    
    @PostMapping
    public ResponseEntity<String> createWorkout(@RequestBody Workout workout) {
        return workoutService.addOrUpdateWorkout(workout, "Workout Created");
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

    @PutMapping
    public ResponseEntity<String> updateWorkout(@RequestBody Workout workout) {
        return workoutService.addOrUpdateWorkout(workout, "Workout Updated");
    }
}

