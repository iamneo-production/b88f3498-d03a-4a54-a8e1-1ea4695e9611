package com.example.springapp.service;

import com.example.springapp.model.Set;

public interface SetServiceInterface {
    public Set getSetById(long id);
    public Iterable<Set> getAllSet();
    public Set getSetByExerciseId(long e_id);
}