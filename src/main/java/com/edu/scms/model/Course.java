package com.edu.scms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String department;
    private String duration;
    private int intakeCapacity;

    // Default Constructor
    public Course() {
    }

    // Parameterized Constructor
    public Course(Long id, String courseName, String department, String duration, int intakeCapacity) {
        this.id = id;
        this.courseName = courseName;
        this.department = department;
        this.duration = duration;
        this.intakeCapacity = intakeCapacity;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getIntakeCapacity() {
        return intakeCapacity;
    }

    public void setIntakeCapacity(int intakeCapacity) {
        this.intakeCapacity = intakeCapacity;
    }
}