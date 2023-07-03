package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.repository.WorkoutRepository;

@RestController
// @CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
@RequestMapping("/workout")
public class WorkoutController {

    // @Autowired
    // private WorkoutRepository workoutRepository;

    // @GetMapping
    // public List<Workout> getAllWorkout(){
    // return (List<Workout>) workoutRepository.findAll();

    // }

    // @GetMapping("/id")
    // public Workout getWorkoutById(long id){
    // Workout optionalWorkout;
    // try{
    // optionalWorkout = workoutRepository.getWorkoutById(id);
    // }catch(Exception e){
    // return null;
    // }
    // return optionalWorkout;
    // }

    // @GetMapping("/userId")
    // public Workout getWorkOutByUserId(long id)

}
