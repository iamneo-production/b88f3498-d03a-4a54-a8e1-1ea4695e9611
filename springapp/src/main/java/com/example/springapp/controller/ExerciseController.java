package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.model.Exercise;
import com.example.springapp.service.ExerciseService;
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.CustomDataAccessException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidUpdateException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<String> createExercise(@Valid @RequestBody Exercise exercise) throws AlreadyExistsException {
        exerciseService.createExercise(exercise);
        return ResponseEntity.ok("Exercise Created");

    }

    @GetMapping
    public Iterable<Exercise> getAllExercise() throws CustomDataAccessException {
        return exerciseService.getAllExercise();
    }

    
    @GetMapping("/id")
    public Exercise getExerciseById(@RequestParam("id") long id) throws ExerciseNotFoundException {
        return exerciseService.getExerciseById(id);
    }


    @GetMapping("/workoutId")
    public List<Exercise> getExerciseByWorkoutId(@RequestParam("workoutId") long workoutId) throws WorkoutNotFoundException {
         return exerciseService.getExerciseByWorkoutId(workoutId);
    }


    @PutMapping
    public ResponseEntity<String> updateExercise(@RequestBody Exercise exercise) throws InvalidUpdateException{
        return exerciseService.updateExercise(exercise);
    }
    
    @DeleteMapping("/id")
    public ResponseEntity<String> deleteExerciseById(@RequestParam("id") long id) throws InvalidDeleteException{
        exerciseService.deleteExerciseById(id);
        return new ResponseEntity<>("Exercise deleted", HttpStatus.OK);

    }
    

}
