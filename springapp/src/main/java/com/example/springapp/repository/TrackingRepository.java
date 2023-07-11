package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.springapp.model.TrackingModel;

public interface TrackingRepository extends CrudRepository<TrackingModel, Integer> {
    Iterable<TrackingModel> findAllByUsername(String email);   
}
