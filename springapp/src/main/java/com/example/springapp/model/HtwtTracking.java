package com.example.springapp.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "htwtTable")

public class HtwtTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "calories")
    private float calories;

    public HtwtTracking() {

    }

    public HtwtTracking(LocalDate date, int height, int weight, int calories) {
        super();
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.calories = calories;
    }

    public long getId() {
        return id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public HtwtTracking(LocalDate date, int height, int weight, float calories) {
        this.date = date;
        this.height = height;
        this.weight = weight;
        this.calories = calories;
    }

}
