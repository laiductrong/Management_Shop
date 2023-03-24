package com.example.demo1.models;

public class Course {
    public Integer courseID;
    public String title;
    public Integer credits;
    public Integer departmentID;

    public Course(Integer courseID, String title, Integer credits, Integer departmentID) {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.departmentID = departmentID;
    }

    public Course(){

    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }
}
