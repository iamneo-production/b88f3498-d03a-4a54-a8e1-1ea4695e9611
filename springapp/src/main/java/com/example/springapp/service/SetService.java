package com.example.springapp.service;

import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Set;
import com.example.springapp.repository.SetRepository;

@Service
public class SetService implements SetServiceInterface {

    @Autowired
    private SetRepository setRepository;

    @Override
    public Iterable<Set> getAllSet() {
        return setRepository.findAll();
    }

    @Override
    public Set getSetById(long id) {
        return setRepository.getSetById(id).orElseThrow();
    }

    @Override
    public Iterable<Set> getSetByExerciseId(long e_id) {
        Iterable<Set> set = setRepository.getSetByExerciseId(e_id);
        int count = (int) StreamSupport.stream(set.spliterator(), false).count();
        if (count > 0) {
            return set;
        }
        return null;
    }

    @Override
    public ResponseEntity<String> deleteSetById(long id) {
        setRepository.deleteSetById(id);
        return new ResponseEntity<String>("Set deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> createSet(Set set) {
        setRepository.save(set);
        return new ResponseEntity<>("Set Created", HttpStatus.CREATED);
    }

}