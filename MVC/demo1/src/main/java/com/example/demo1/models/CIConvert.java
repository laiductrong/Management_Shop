package com.example.demo1.models;

public class CIConvert {
    public Course course;
    public Person person;

    public CIConvert(Course course, Person person) {
        this.course = course;
        this.person = person;
    }

    public CIConvert() {

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
