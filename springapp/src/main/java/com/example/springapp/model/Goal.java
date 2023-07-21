package com.example.springapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotNull(message = "Name is not valid")
    @Size(min = 3, message = "Length of name should be atleast 3 characters long")
    private String name;

    @NotBlank(message = "Notes is required")
    @Size(max = 100, message = "Notes must be a maximum of 100 characters")
    private String notes;

    @NotNull(message = "Intensity is required")
    private String intensity;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Duration is required")
    private int duration;

    @NotNull(message = "Status is required")
    private String status;

    public Goal(){}

    public Goal(long id,
            @NotNull(message = "Name is not valid") @Size(min = 3, message = "Length of name should be atleast 3 characters long") String name,
            @NotBlank(message = "Notes is required") @Size(max = 100, message = "Notes must be a maximum of 100 characters") String notes,
            @NotNull(message = "Intensity is required") String intensity,
            @NotNull(message = "Date is required") LocalDate date,
            @NotNull(message = "Duration is required") int duration,
            @NotNull(message = "Duration is required") String status) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.intensity = intensity;
        this.date = date;
        this.duration = duration;
        this.status = status;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Goal [id=" + id + ", name=" + name + ", notes=" + notes + ", intensity=" + intensity + ", date=" + date
                + ", duration=" + duration + ", status=" + status + "]";
    }

}
