package com.example.springapp.service;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Set;
import com.example.springapp.repository.SetRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.springapp.exception.SetsNotFoundException;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.InvalidUpdateException;
import com.example.springapp.exception.DeleteSetException;


@Transactional
@Service
public class SetService implements SetServiceInterface {

    @Autowired
    private SetRepository setRepository;

    @Override
    public Iterable<Set> getAllSet() {
        return setRepository.findAll();
    }

    @Override
    public Set getSetById(long id) throws SetsNotFoundException {
        Optional<Set> set = setRepository.getSetById(id);
        if(set.isEmpty()){
            throw new SetsNotFoundException("Set does not exists for particular ID");
        }
        return setRepository.getSetById(id).get();
    }

    @Override
    public Iterable<Set> getSetByExerciseId(long e_id) throws ExerciseNotFoundException {
        Iterable<Set> set = setRepository.getSetByExerciseId(e_id);
        int count = (int) StreamSupport.stream(set.spliterator(), false).count();
        if (count<=0) {
            throw new ExerciseNotFoundException("Exercise does not exists for particular set ID");
        }
        return set;
    }


    @Override
    public ResponseEntity<String> deleteSetById(long id) throws DeleteSetException {
        try {
            setRepository.deleteSetById(id);
        } catch (Exception e) {
            throw new DeleteSetException("Error occurred while deleting the set with ID: " + id);
        }
        return new ResponseEntity<>("Set deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> createSet(Set set) throws AlreadyExistsException{
        Iterable<Set> dbset = setRepository.getSetByExerciseId(set.getExerciseId());
        int count = (int) StreamSupport.stream(dbset.spliterator(), false).count();
        if (count>0) {
            throw new AlreadyExistsException("Set Already Exists");
        }
        setRepository.save(set);
        return new ResponseEntity<>("Set Created", HttpStatus.CREATED);
    }
    public ResponseEntity<String> updateSet(Set set) throws InvalidUpdateException{
        Set dbSet = setRepository.findById(set.getId()).orElseThrow();
        dbSet.setExerciseId(set.getExerciseId());
        dbSet.setReps(set.getReps());
        dbSet.setWeight(set.getWeight());
        dbSet.setDuration(set.getDuration());
        setRepository.save(dbSet);
        return new ResponseEntity<>("Set Updated", HttpStatus.OK);
    }

}