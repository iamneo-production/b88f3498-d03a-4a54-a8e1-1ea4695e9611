package com.example.springapp.ExerciseTracking;

import org.springframework.data.repository.CrudRepository;

public interface TrackingRepository extends CrudRepository<TrackingModel, Integer> {
    
}
