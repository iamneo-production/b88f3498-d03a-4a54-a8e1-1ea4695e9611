package com.example.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.springapp.exception.SetsNotFoundException;
import com.example.springapp.exception.ExerciseNotFoundException;
import com.example.springapp.exception.InvalidDeleteException;
import com.example.springapp.exception.InvalidUpdateException;
import com.example.springapp.exception.AlreadyExistsException;
import com.example.springapp.exception.CustomDataAccessException;
import com.example.springapp.exception.DeleteSetException;
import com.example.springapp.model.Set;
import com.example.springapp.service.SetService;
import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Transactional
@RestController
@RequestMapping("/set")
public class SetController {

    @Autowired
    private SetService setService;

    // to retrieve all set
    @GetMapping
    public Iterable<Set> getAllSet() throws CustomDataAccessException{
        return setService.getAllSet();
    }

    @PostMapping
    public ResponseEntity<String> createSet(@Valid @RequestBody Set set) throws AlreadyExistsException {
        return setService.createSet(set);

    }

    @GetMapping("/id")
    public Set getSetById(@RequestParam("id") long id) throws SetsNotFoundException {
        return setService.getSetById(id);
    }

    @GetMapping("/exerciseId")
    public Iterable<Set> getSetByExerciseId(@RequestParam("exerciseId") long e_id) throws ExerciseNotFoundException {
        return setService.getSetByExerciseId(e_id);
    }

   
    @DeleteMapping
    public ResponseEntity<String> deleteSetById(@RequestParam("id") long id) throws DeleteSetException  {

        setService.deleteSetById(id);
        return new ResponseEntity<>("Set deleted", HttpStatus.OK);

    }


    
    @PutMapping
    public ResponseEntity<String> updateSet(@RequestBody Set set) throws InvalidUpdateException{
        return setService.updateSet(set);
    }

}
