package com.example.springapp.repository;

import com.example.springapp.model.Goal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GoalRepository  extends CrudRepository<Goal, Long> {
    
    List<Goal> findAllByStatus(String status);

}