package com.example.springapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.springapp.model.Exercise;
import com.example.springapp.model.Workout;
import com.example.springapp.service.ExerciseService;
import com.example.springapp.repository.ExerciseRepository;


@RestController
@CrossOrigin("*")
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ExerciseRepository exerciseRepository;

   
    // @PostMapping("/add")
    // public ResponseEntity<String> createExercise(@RequestBody Exercise exercise) {
    //     long workoutId = exercise.getWorkoutId();
    //     Workout newWorkout = new Workout();
    //     newWorkout.setId(workoutId);
    //     exercise.setWorkout(newWorkout);
    //     Exercise createdExercise = exerciseRepository.save(exercise);
    //     if (createdExercise != null) {
    //         return ResponseEntity.ok("Exercise Created");
    //     } else {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }
    @GetMapping
    public Iterable<Exercise> getAllExercise() {
        return exerciseService.getAllExercise();
    }
    @GetMapping("/id")
    public Exercise getExerciseById(@RequestParam("id") long id){
        return exerciseService.getExerciseById(id);
    }

    @DeleteMapping("/id")
    public void deleteExerciseById(@RequestParam("id") long id){
         exerciseService.getExerciseById(id);
    }
    
    

}


