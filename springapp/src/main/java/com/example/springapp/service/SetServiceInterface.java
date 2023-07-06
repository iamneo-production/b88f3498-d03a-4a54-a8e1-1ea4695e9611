package com.example.springapp.service;

import org.springframework.http.ResponseEntity;

import com.example.springapp.model.Set;

public interface SetServiceInterface {
    Set getSetById(long id);

    Iterable<Set> getAllSet();

    Iterable<Set> getSetByExerciseId(long e_id);

    ResponseEntity<String> deleteSetById(long id);
    // Set createSet();
}
