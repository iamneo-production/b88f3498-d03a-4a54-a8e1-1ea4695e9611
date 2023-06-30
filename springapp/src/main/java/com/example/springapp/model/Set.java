package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long exerciseId;
    private long reps;
    private String duration;
    private String weight;

    
    // not given in condition of examly
    // @ManyToOne
    // @JoinColumn(name = "user_id")
    public Set() {
    }

    public Set(long id, long exerciseid, long reps, String weight, String duration) {
        this.id = id;
        this.exerciseId = exerciseid;
        this.reps = reps;
        this.weight = weight;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReps() {
        return reps;
    }

    public void setReps(long reps) {
        this.reps = reps;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }




}
