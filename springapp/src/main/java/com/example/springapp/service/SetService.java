package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.stream.StreamSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.example.springapp.model.Set;
import com.example.springapp.repository.SetRepository;

@Service
public class SetService implements SetServiceInterface  {

    @Autowired
    private SetRepository setRepository;

    @Override
    public Set getSetById(long id){
        return setRepository.getSetById(id).orElseThrow();
    }

    @Override
    public Iterable<Set> getAllSet(){
        return setRepository.findAll();
    }

    @Override
    public Iterable<Set> getSetByExerciseId(long e_id){
         Iterable<Set> set = setRepository.getSetByExerciseId(e_id);
         int count = (int) StreamSupport.stream(set.spliterator(), false).count();
         if(count > 0){
            return set;
         }
        return null;
    }

    @Override
    public void deleteSetById(long id){
         setRepository.deleteSetById(id);
    }

    public ResponseEntity<Set> createSet(Set set){
        Set sets = setRepository.findBySetId(set.getId());
        if(sets!=null){
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("message", "Set Already Exists!!!");
            
            return new ResponseEntity<>(map, HttpStatus.ALREADY_REPORTED);
        }
        setRepository.save(set);
        return new ResponseEntity<>(set, HttpStatus.CREATED);
    }



}