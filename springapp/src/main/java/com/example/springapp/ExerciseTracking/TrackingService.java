package com.example.springapp.ExerciseTracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrackingService {
    @Autowired
    public TrackingRepository todos;

    // public static List<TrackingModel> todos = new ArrayList<TrackingModel>();
    // private static int idCounter = 0;

    // static {
    // todos.add(new TrackingModel(++idCounter, "darshan", "pullups", new Date(),
    // true));
    // }

    public Iterable<TrackingModel> findAll() {
        return todos.findAll();
    }

    public TrackingModel save(TrackingModel todo) {
        return todos.save(todo);
        // if (todo.getId() == -1 || todo.getId() == 0) {
        // todo.setId(++idCounter);
        // todos.add(todo);
        // } else {
        // deleteById(todo.getId());
        // todos.add(todo);
        // }
        // return todo;
    }

    public ResponseEntity<String> deleteById(int id) {
        TrackingModel todo = todos.findById(id).get();
        if (todo == null)
            return new ResponseEntity<String>("User is not present", HttpStatus.NOT_FOUND);
        todos.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    public TrackingModel findById(int id) {
        return todos.findById(id).get();
    }

}
