package com.example.springapp.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.repository.ExerciseRepository;
import com.example.springapp.model.Exercise;

@Service
public class ExerciseService implements ExerciseServiceInterface{

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public List<Exercise> getAllExercise(){
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise getExerciseById(long id) throws ExerciseNotFoundException{
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if(!exercise.isPresent()){
            throw new ExerciseNotFoundException("Exercise not found for the particular id");
        }
        return exerciseRepository.findById(id).get();
    }

    @Override
    public List<Exercise> getExerciseByWorkoutId(long w_id) throws ExerciseNotFoundException{
        List<Exercise> exercises = exerciseRepository.findByWorkoutId(w_id);
        if(exercises.isEmpty()){
            throw new ExerciseNotFoundException("Exercise not found for the particular workout id");
        }
        return exercises;
    }
}