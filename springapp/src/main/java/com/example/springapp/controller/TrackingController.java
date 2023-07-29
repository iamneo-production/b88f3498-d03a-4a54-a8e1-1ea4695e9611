package com.example.springapp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.springapp.service.TrackingService;
import com.example.springapp.model.TrackingModel;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class TrackingController {
    @Autowired
    public TrackingService trackingService;


        @GetMapping("/users/{username}/todos")
    public Iterable<TrackingModel> getAllTodos(@PathVariable String username){
        return trackingService.findAll(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public TrackingModel GetById(@PathVariable String username, @PathVariable int id){
        return trackingService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<String> deleteSetById(@PathVariable String username, @PathVariable int id){
         trackingService.deleteById(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<TrackingModel> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TrackingModel todo){
        todo.setUsername(username);
        TrackingModel todoUpdated = trackingService.save(todo);
        return new ResponseEntity<TrackingModel>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<TrackingModel> createTodo(@PathVariable String username, @RequestBody TrackingModel todo) {
        todo.setUsername(username);

        TrackingModel newModel = trackingService.save(todo);
        return new ResponseEntity<>(newModel, HttpStatus.CREATED);
    }
    
    
    
}

