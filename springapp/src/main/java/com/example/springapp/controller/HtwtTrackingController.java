package com.example.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.HtwtTracking;
import com.example.springapp.repository.HtwtTrackingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class HtwtTrackingController {

    @Autowired
    private HtwtTrackingRepository trackingRepository;

    @GetMapping("/tracking/{userId}")
    public Iterable<HtwtTracking> getValuesById(@PathVariable("userId") long userId) {
        return trackingRepository.findAllByUserId(userId);
    }

    @PostMapping("/tracking")
    public ResponseEntity<?> saveData(@RequestBody HtwtTracking data) {
        double height = data.getHeight();
        double weight = data.getWeight();
        long userId = data.getUserId();
 
    
        // Process the data (e.g., calculate BMI)
        double bmi = calculateBMI(height, weight);
        // List li = new ArrayList();
        // li.add(height);
        // li.add(weight);
        // li.add(bmi);
        HtwtTracking htwtdata = new HtwtTracking(data.getDate(),userId, height, weight, bmi);
        

        trackingRepository.save(htwtdata);
    
        // Create a response object
        // DataResponse response = new DataResponse(height, weight, bmi);
    
        // Return the response
        return ResponseEntity.ok(htwtdata);
      }
      private double calculateBMI(double height, double weight) {
        // Perform the BMI calculation here
        // Example calculation: BMI = weight / (height * height)
        double heightInMeters = height / 100.0; // Convert height to meters
        return weight / (heightInMeters * heightInMeters);
      }
    
}
