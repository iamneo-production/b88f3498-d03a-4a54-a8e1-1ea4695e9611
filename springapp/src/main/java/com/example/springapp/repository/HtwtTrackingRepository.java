package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springapp.model.HtwtTracking;

public interface HtwtTrackingRepository extends CrudRepository<HtwtTracking, Long> {

    Iterable<HtwtTracking>findAllByUserId(long userId);

}
