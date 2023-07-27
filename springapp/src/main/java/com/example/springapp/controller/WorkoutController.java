package com.example.springapp.controller;

import java.util.*;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidInputException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.example.springapp.model.Set;
import com.example.springapp.model.User;
import com.example.springapp.model.Workout;
import com.example.springapp.repository.UserRepository;
import com.example.springapp.repository.WorkoutRepository;
import com.example.springapp.model.Workout;
import com.example.springapp.service.WorkoutService;
import com.example.springapp.exception.WorkoutNotFoundException;

import com.example.springapp.exception.CustomDataAccessException;
import com.example.springapp.exception.UserNotFoundException;
import com.example.springapp.exception.InvalidInputException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.AlreadyExistsException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping
@Transactional
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/workout")
    public ResponseEntity<String> createWorkout(@Valid @RequestBody Workout workout) throws AlreadyExistsException{
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/workout")
    public ResponseEntity<Iterable<Workout>> getAllWorkouts()throws CustomDataAccessException {
        Iterable<Workout> workouts = workoutService.getAllWorkout();
        return ResponseEntity.ok(workouts);
    }

    @GetMapping("/workout/id")
    public Workout getWorkoutById(@RequestParam("id") long id) throws WorkoutNotFoundException {
        return workoutService.getWorkoutById(id);
    }

    @GetMapping("/workout/userId")
    public List<Workout> getWorkoutByUserId(@RequestParam("userId") long id) throws UserNotFoundException{
        return workoutService.getWorkOutByUserId(id);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateWorkout(@RequestBody Workout workout) throws InvalidInputException {
        return workoutService.updateWorkout(workout);
    }

    @DeleteMapping("/workout/id")
    public ResponseEntity<String> deleteWorkoutById(@RequestParam("id") long id) throws InvalidDeleteException {
        return workoutService.deleteWorkoutById(id);
    }

    @PostMapping("/workout/addToHistory")
    public ResponseEntity<HashMap<String,Object>> addToWorkoutHistory(@RequestBody HashMap<String,Object> body) throws InvalidDeleteException {
        return workoutService.addToWorkoutHistory(body);
    }

    @GetMapping("/workout/history")
    public ResponseEntity<List<HashMap<String,Object>>> getWorkoutHistory(@RequestParam("userId") long id){
        return workoutService.getHistory(id);
    }

    @DeleteMapping("/workout/history/delete/{id}")
    public ResponseEntity<String> deleteWorkoutHistory(@PathVariable("id") long id) throws InvalidDeleteException{
        workoutService.deleteHistoryById(id);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

}
