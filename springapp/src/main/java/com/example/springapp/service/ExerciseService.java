package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Exercise;
import com.example.springapp.repository.ExerciseRepository;
import com.example.springapp.exception.ExerciseNotFoundException;


@Service
public class ExerciseService extends RuntimeException implements ExerciseServiceInterface {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Iterable<Exercise> getAllExercise() {
        return exerciseRepository.findAll();

    }

    @Override
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException {
        Optional<Exercise> optionalExercise = exerciseRepository.findExerciseById(id);
        if(optionalExercise.isEmpty()){
            throw new ExerciseNotFoundException("Exercise does not exists for particular ID");
        }
        return optionalExercise.orElseThrow();
    }

    @Override
    public List<Exercise> getExerciseByWorkoutId(long workoutId) {
        return exerciseRepository.findAllByWorkoutId(workoutId);

    }

    @Override
    public void deleteExerciseById(long id) {
        exerciseRepository.deleteById(id);
    }

    public ResponseEntity<String> createExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
        return new ResponseEntity<>("exercise created", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateExercise(Exercise exercise) {
        Exercise dbExercise = exerciseRepository.findById(exercise.getId()).orElseThrow();
        dbExercise.setDescription(exercise.getDescription());
        dbExercise.setName(exercise.getName());
        dbExercise.setWorkoutId(exercise.getWorkoutId());
        exerciseRepository.save(dbExercise);
        return new ResponseEntity<>("exercise Updated", HttpStatus.OK);
    }

}
