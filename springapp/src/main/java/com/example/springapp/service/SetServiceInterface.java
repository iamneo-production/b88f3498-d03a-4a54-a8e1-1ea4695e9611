package com.example.springapp.service;

import org.springframework.http.ResponseEntity;

import com.example.springapp.model.Set;
import com.example.springapp.exception.SetsNotFoundException;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.InvalidDeleteException;

public interface SetServiceInterface {
    Set getSetById(long id) throws SetsNotFoundException;

    Iterable<Set> getAllSet();

    Iterable<Set> getSetByExerciseId(long e_id) throws ExerciseNotFoundException;

    ResponseEntity<String> deleteSetById(long id) throws InvalidDeleteException;
    
    ResponseEntity<String> createSet(Set set) throws AlreadyExistsException;

    
}
