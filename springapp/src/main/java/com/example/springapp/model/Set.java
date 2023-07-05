package com.example.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "setTable")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long exerciseId;
    private Long reps;
    private String weight;
    private String duration;

    public Set() {

    }

    public Set(Long exerciseId, Long reps, String weight, String duration) {
        this.exerciseId = exerciseId;
        this.reps = reps;
        this.weight = weight;
        this.duration = duration;
    }

    public Set(Long id, Long reps, Long exerciseId, String weight, String duration) {
        this.id = id;
        this.reps = reps;
        this.weight = weight;
        this.duration = duration;
        this.exerciseId = exerciseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReps() {
        return reps;
    }

    public void setReps(Long reps) {
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

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
}
