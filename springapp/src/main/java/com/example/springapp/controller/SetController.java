package main.java.com.example.springapp.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.springapp.model.Set;
import com.example.springapp.service.SetService;
import com.example.springapp.repository.SetRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/set")
public class SetController {

    @Autowired
    private SetService setService;

    @GetMapping
    public Iterable<Set> getAllSet() {
        return setService.getAllSet();
    }
    @GetMapping("/id")
    public Set getSetById(@RequestParam("id") long id){
        return setService.getSetById(id);
    }

    @GetMapping("/exercise/id")
    public Iterable<Set> getSetByExerciseId(@RequestParam("id")long e_id){
        return setService.getSetByExerciseId(e_id);
    }

    @DeleteMapping("/id")
    public void deleteSetById(@RequestParam("id") long id){
         setService.deleteSetById(id);
    }

    @PostMapping
    public ResponseEntity<Set> createSet(@RequestBody Set set){
        return setService.createSet(set);
    }  

}
