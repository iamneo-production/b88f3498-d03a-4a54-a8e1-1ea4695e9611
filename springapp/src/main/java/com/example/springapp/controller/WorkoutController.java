package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.springapp.model.Workout;
import com.example.springapp.service.WorkoutService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/workout")
    public ResponseEntity<String> createWorkout(@RequestBody Workout workout) {
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/workout")
    public ResponseEntity<Iterable<Workout>> getAllWorkouts() {
        Iterable<Workout> workouts = workoutService.getAllWorkout();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/workout/id")
    public Workout getWorkoutById(@RequestParam("id") long id) {
        return workoutService.getWorkoutById(id);
    }

    @GetMapping("/workout/userId")
    public List<Workout> getWorkoutByUserId(@RequestParam("userId") long id) {
        return workoutService.getWorkOutByUserId(id);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateWorkout(@RequestBody Workout workout) {
        return workoutService.updateWorkout(workout);
    }

    @DeleteMapping("/workout/id")
    public ResponseEntity<String> deleteWorkoutById(@RequestParam("id") long id) {
        return workoutService.deleteWorkoutById(id);
    }
}
