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
import com.example.springapp.exception.WorkoutNotFoundException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidUpdateException;


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
    public List<Exercise> getExerciseByWorkoutId(long workoutId) throws WorkoutNotFoundException {
        List<Exercise> exercises = exerciseRepository.findAllByWorkoutId(workoutId);
        if(exercises.isEmpty()){
            throw new WorkoutNotFoundException("Exercise not found for particular Workout Id");
        }
        return exerciseRepository.findAllByWorkoutId(workoutId);

    }

    @Override
   public ResponseEntity<String> deleteExerciseById(long id) throws InvalidDeleteException{
    try {

        exerciseRepository.deleteExerciseById(id);
        return new ResponseEntity<>("Exercise deleted", HttpStatus.OK);
        } catch (Exception e) {

        throw new InvalidDeleteException("Error occurred while deleting the exercise.");
        }
    }

    public ResponseEntity<String> createExercise(Exercise exercise) throws AlreadyExistsException {
        List<Exercise> exercises = exerciseRepository.findAllByWorkoutId(exercise.getWorkoutId());
        if(!exercises.isEmpty()){
            throw new AlreadyExistsException("Exercise Already Exists with particular Workout Id");
        }
        exerciseRepository.save(exercise);
        return new ResponseEntity<>("exercise created", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateExercise(Exercise exercise) throws InvalidUpdateException{
        Exercise dbExercise = exerciseRepository.findById(exercise.getId()).orElseThrow();
        dbExercise.setDescription(exercise.getDescription());
        dbExercise.setName(exercise.getName());
        dbExercise.setWorkoutId(exercise.getWorkoutId());
        exerciseRepository.save(dbExercise);
        return new ResponseEntity<>("exercise Updated", HttpStatus.OK);
    }

}
