package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.Workout;

import com.example.springapp.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public interface WorkoutRepository extends CrudRepository<Workout, Long> {

    Workout getWorkoutById(long id);
    
}
