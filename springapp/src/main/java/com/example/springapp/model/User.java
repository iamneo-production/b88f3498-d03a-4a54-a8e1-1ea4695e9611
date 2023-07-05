package com.example.springapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password;
    private String height;
    private String weight;
    private long age;
    private String gender;
    private String goals;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Workout> workout;
   

    public User() {
        
    }


    public User(long id, String name, String email, String password, String height, String weight, long age,
            String gender, String goals, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.goals = goals;
        this.role = role;
        this.workout = new ArrayList<>();
    }

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public List<Workout> getWorkout() {
        return workout;
    }
    
    @JsonProperty("workout")
    public void setWorkout(List<Workout> workout) {
        this.workout = workout;
    }


    
}