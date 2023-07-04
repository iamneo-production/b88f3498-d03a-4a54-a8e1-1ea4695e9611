package com.example.springapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.springapp.model.Workout;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public interface WorkoutRepository extends CrudRepository<Workout, Long> {


    Optional<Workout> findWorkoutById(long id);

}
