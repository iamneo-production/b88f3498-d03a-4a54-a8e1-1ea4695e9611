package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.springapp.model.Set;
import com.example.springapp.repository.SetRepository;

@Service
public class SetService implements SetServiceInterface  {

    @Autowired
    private SetRepository setRepository;

    @Override
    public Set getSetById(Long id){
        Optional<Set> set = setRepository.getSetById(id);
        return set.orElseThrow();
    }

    @Override
    public Iterable<Set> getAllSet(){
        return setRepository.findAll();
    }

    @Override
    public Iterable<Set> getSetByExerciseId(long e_id){
         Iterable<Set> set = setRepository.getSetByExerciseId(e_id);
         int count = StreamSupport.stream(set.spliterator(), false).count();
         if(count > 0){
            return set;
         }
        return null;
    }

    @Override
    public void deleteSetById(long id){
         exerciseRepository.deleteSetById(id);
    }



}