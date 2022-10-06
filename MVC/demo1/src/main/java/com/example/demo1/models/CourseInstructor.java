package com.example.demo1.models;

public class CourseInstructor {
    public Integer courseID;
    public Integer personID;

    public CourseInstructor(Integer courseID, Integer personID) {
        this.courseID = courseID;
        this.personID = personID;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }
}
