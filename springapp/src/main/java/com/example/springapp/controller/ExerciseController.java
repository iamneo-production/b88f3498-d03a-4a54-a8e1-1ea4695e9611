package com.example.springapp.controller;

<<<<<<< HEAD
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;import com.example.springapp.service.ExerciseService;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
@RestController
public class ExerciseController {

    @Autowired()
    private ExerciseServiceInterface exerciseServiceInterface;


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
=======
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
@CrossOrigin
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


>>>>>>> 0f7aca6afa9e6b43818a1829a09ebc0b896c73ad
