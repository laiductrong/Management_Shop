package com.example.demo1.models;

public class SGConvert {
    public Person person;
    public Course course;
    public int enrollmentID;
    public String grade;

    public SGConvert() {
    }

    public SGConvert(Person person, Course course, int enrollmentID, String grade) {
        this.person = person;
        this.course = course;
        this.enrollmentID = enrollmentID;
        this.grade = grade;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
