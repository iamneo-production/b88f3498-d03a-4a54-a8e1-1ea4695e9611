package com.example.springapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private long id;
    @NotNull(message = "name is not valid")
    @Size(min = 3, message = "length of name should be atleast 3 characters")
    private String name;
    @NotNull(message = "Email should not be null")
    @Email(message = "email is not valid")
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "Password must have 8 characters containing atleast one uppercase, one lowercase and one Number")
    private String password;

    @NotNull(message = "Height should not be null")
    private String height;


    @NotNull(message = "Weight should not be null")
    private String weight;
    
    @NotNull(message = "Age should not be null")
    @Positive(message = "age must be greater than 0")
    private long age;
    @NotNull(message = "select atleast one gender")
    private String gender;

    @NotNull(message = "select atleast one goal")
    private String goals;

    @NotNull(message = "select atleast one role")
    private String role ="USER";

    @OneToMany(mappedBy = "user")
    private List<Workout> workout;

    private Boolean enabled=true;
   


    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public User() {
        
    }


   
    public User(String name, String email, String password, String height, String weight, long age,
            String gender, String goals, String role, boolean isEnabled) {
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
        this.enabled = isEnabled;
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