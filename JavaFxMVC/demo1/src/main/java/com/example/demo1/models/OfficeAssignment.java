package com.example.demo1.models;

public class OfficeAssignment {
    public Integer instructorID;
    public String location; // default : TP.HCM
    public String timestamp; // convert from timestamp to string

    public OfficeAssignment(Integer instructorID, String location, String timestamp) {
        this.instructorID = instructorID;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Integer getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        this.instructorID = instructorID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
