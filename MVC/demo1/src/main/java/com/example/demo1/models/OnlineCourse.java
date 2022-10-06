package com.example.demo1.models;

public class OnlineCourse {

    public Integer courseID;
    public String url;

    public OnlineCourse(Integer courseID, String url) {
        this.courseID = courseID;
        this.url = url;
    }

    public OnlineCourse() {

    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
