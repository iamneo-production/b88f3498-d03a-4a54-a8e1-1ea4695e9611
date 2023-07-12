package com.example.springapp.repository;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import com.example.springapp.model.HtwtTracking;

// @Repository

public interface HtwtTrackingRepository extends CrudRepository<HtwtTracking, Long> {

    Iterable<HtwtTracking>findAllByUserId(long userId);

}
