package com.example.demo1.models;

public class OnsiteCourse {
    public Integer courseID;
    public String location;
    public String days;
    public String time; //convert from 'Time' to 'String'

    public OnsiteCourse(Integer courseID, String location, String days, String time) {
        this.courseID = courseID;
        this.location = location;
        this.days = days;
        this.time = time;
    }

     public OnsiteCourse(){

     }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
