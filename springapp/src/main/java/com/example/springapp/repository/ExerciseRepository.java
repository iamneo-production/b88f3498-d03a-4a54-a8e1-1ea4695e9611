package com.example.springapp.repository;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.repository.JpaRepository;

import com.example.springapp.model.User;
import com.example.springapp.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public interface ExerciseRepository extends JpaRepository<Exercise,Long>
{
=======

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.Exercise;
import com.example.springapp.model.Workout;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    Optional<Exercise> findExerciseById(long id);
    Exercise deleteExerciseById(long id);
>>>>>>> 0f7aca6afa9e6b43818a1829a09ebc0b896c73ad

    
}
