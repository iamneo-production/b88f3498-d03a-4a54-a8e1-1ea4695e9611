package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Exercise;
import com.example.springapp.service.ExerciseService;

@RestController
@CrossOrigin("*")
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<String> createExercise(@RequestBody Exercise exercise) {
        exerciseService.createExercise(exercise);
        return ResponseEntity.ok("exercise Created");

    }

    @GetMapping
    public Iterable<Exercise> getAllExercise() {
        return exerciseService.getAllExercise();
    }

    @GetMapping("/id")
    public Exercise getExerciseById(@RequestParam("id") long id) {
        return exerciseService.getExerciseById(id);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteExerciseById(@RequestParam("id") long id) {
        exerciseService.deleteExerciseById(id);
        return new ResponseEntity<String>("Exercise deleted", HttpStatus.OK);

    }

    @GetMapping("/workout")
    public List<Exercise> ExerciseByWorkoutId(@RequestParam("workout") long workoutId) {
        return exerciseService.getExerciseByWorkoutId(workoutId);
    }

    @PutMapping
    public ResponseEntity<String> updateExercise(@RequestBody Exercise exercise) {
        return exerciseService.updateExercise(exercise);
    }

}