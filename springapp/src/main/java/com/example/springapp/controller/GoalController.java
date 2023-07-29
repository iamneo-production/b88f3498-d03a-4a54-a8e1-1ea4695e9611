package com.example.springapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Goal;
import com.example.springapp.service.GoalService;

@CrossOrigin
@RestController
@RequestMapping("/goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping("/set")
    public ResponseEntity<String> setGoal(@RequestBody HashMap<String,Object> body){
        return goalService.setGoal(body);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Goal>> getAllGoals(@RequestParam("status") String status){
        return goalService.getGoalData(status);
    }
}
