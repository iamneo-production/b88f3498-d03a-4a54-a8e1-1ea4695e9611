package com.example.springapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.Exercise;
import com.example.springapp.model.Workout;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public interface SetRepository extends CrudRepository<Set,Long>{

    Optional<Set> getSetById(Long id);

    Iterable<Set> getSetByExerciseId(long e_id);
}



