package com.example.springapp.repository;
import java.util.Optional;

import org.springframework.data.repository.JpaRepository;

import com.example.springapp.model.User;
import com.example.springapp.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://8081-bfbbcbbafccbbbdaaaccdcddcffebdffccbebc.project.examly.io")
public interface ExerciseRepository extends JpaRepository<Exercise,Long>
{

    
}
