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
import com.example.springapp.exception.CustomDataAccessException;
import com.example.springapp.exception.InvalidUpdateException;
import com.example.springapp.exception.InvalidDeleteException;



@Service
public class ExerciseService extends RuntimeException implements ExerciseServiceInterface {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Iterable<Exercise> getAllExercise() throws CustomDataAccessException {
        try{
        return exerciseRepository.findAll();
        }catch(Exception e){
            throw new CustomDataAccessException("Error occurred while retrieving all exercises", e);

        }
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

   
    public ResponseEntity<String> deleteExerciseById(long id) throws InvalidDeleteException{
        try {
    
            exerciseRepository.deleteExerciseById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occured during deleting exercise Id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Exercise deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> createExercise(Exercise exercise) throws AlreadyExistsException {

        List<Exercise> exercises = exerciseRepository.findAllByWorkoutId(exercise.getWorkoutId());

        if(!exercises.isEmpty()){

            throw new AlreadyExistsException("Exercise Already Exists with particular Workout Id");
        }
        exerciseRepository.save(exercise);
        return new ResponseEntity<>("Exercise created", HttpStatus.CREATED);
    }



    
    public ResponseEntity<String> updateExercise(Exercise exercise) throws InvalidUpdateException {
        try {
            Exercise dbExercise = exerciseRepository.findById(exercise.getId())
                    .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found for the provided ID"));
    
            dbExercise.setDescription(exercise.getDescription());
            dbExercise.setName(exercise.getName());
            dbExercise.setWorkoutId(exercise.getWorkoutId());
    
            exerciseRepository.save(dbExercise);
            return new ResponseEntity<>("Exercise updated", HttpStatus.OK);
        } catch (Exception e) {
            throw new InvalidUpdateException("Error occurred while updating the exercise.");
        }
    }

}
