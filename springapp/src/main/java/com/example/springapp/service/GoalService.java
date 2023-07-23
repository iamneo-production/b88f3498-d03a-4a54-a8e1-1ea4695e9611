package com.example.springapp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Goal;
import com.example.springapp.repository.GoalRepository;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public ResponseEntity<String> setGoal(HashMap<String,Object> body){
        
        //Get local date from body
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse((String)body.get("date"), formatter);
        //create a goal object to save
        Goal goal = new Goal(
            0,
            (String)body.get("name"),
            (String)body.get("notes"),
            (String)body.get("intensity"),
            localDate,
            (int)body.get("duration"),
            (String)body.get("status")
        );

        Goal createdGoal = goalRepository.save(goal);
        if(createdGoal!=null){
            return new ResponseEntity<String>("Goal created Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Please Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // return new ResponseEntity<String>(goal.toString(), HttpStatus.OK);
    }

    public ResponseEntity<List<Goal>> getGoalData(String status){

        //get all goals by given status
        List<Goal> goals = goalRepository.findAllByStatus(status);
        return new ResponseEntity<List<Goal>>(goals,HttpStatus.OK);

    }

}
