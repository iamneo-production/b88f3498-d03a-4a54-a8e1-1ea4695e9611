package com.example.springapp.service;

import org.springframework.http.ResponseEntity;
import com.example.springapp.model.Set;


import com.example.springapp.exception.SetsNotFoundException;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.DeleteSetException;
import com.example.springapp.exception.CustomDataAccessException;

public interface SetServiceInterface {
    
    Set getSetById(long id) throws SetsNotFoundException;

    Iterable<Set> getAllSet() throws CustomDataAccessException;

    Iterable<Set> getSetByExerciseId(long e_id) throws ExerciseNotFoundException;

    ResponseEntity<String> deleteSetById(long id) throws DeleteSetException;
    
    ResponseEntity<String> createSet(Set set) throws AlreadyExistsException;

    
}
