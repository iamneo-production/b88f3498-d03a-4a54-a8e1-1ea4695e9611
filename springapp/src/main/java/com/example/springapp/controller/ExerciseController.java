package com.example.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;import com.example.springapp.service.ExerciseService;


@RestController
public class ExerciseController {

    @Autowired()
    private ExerciseServiceInterface exerciseServiceInterface;


    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/exercise")
    public ResponseEntity<List<Exercise>> getAllExercises(){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<String,String>();
        map.add("message","All Exercises are displayed");
        ResponseEntity<List<Exercise>> responseEntity = new ResponseEntity<List<Exercise>>(exerciseServiceInterface.getAllExercise(),map,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id) throws ExerciseNotFoundException{
        ResponseEntity<Exercise> responseEntity = new ResponseEntity<Exercise>(exerciseServiceInterface.getExerciseById(id),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/exercise/workout/{id}")
    public ResponseEntity<List<Exercise>> getExerciseByWorkoutId(@PathVariable Long id) throws ExerciseNotFoundException{
        ResponseEntity<List<Exercise>> responseEntity = new ResponseEntity<List<Exercise>>(exerciseServiceInterface.getExerciseByWorkoutId(id),HttpStatus.OK);
        return responseEntity;
    }
    
}
