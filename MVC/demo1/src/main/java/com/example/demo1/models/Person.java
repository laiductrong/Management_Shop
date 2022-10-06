package com.example.demo1.models;

public class Person {
    public Integer personID;
    public String lastName;
    public String firstName;
    public String hireDate; //convert form 'Datetime' to 'String'
    public String enrollmentDate; //convert form 'Datetime' to 'String'

    public Person(Integer personID, String lastName, String firstName, String hireDate, String enrollmentDate) {
        this.personID = personID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.hireDate = hireDate;
        this.enrollmentDate = enrollmentDate;
    }

    public Person() {

    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}








//package com.example.demo1.models;
//
//import javafx.beans.property.IntegerProperty;
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//public class Person {
//    public IntegerProperty personID;
//    public StringProperty lastName;
//    public StringProperty firstName;
//    public StringProperty hireDate; //convert form 'Datetime' to 'String'
//    public StringProperty enrollmentDate; //convert form 'Datetime' to 'String'
//
//    public Person(Integer personID, String lastName, String firstName, String hireDate, String enrollmentDate) {
//        this.personID = new SimpleIntegerProperty(personID);
//        this.lastName = new SimpleStringProperty(lastName);
//        this.firstName = new SimpleStringProperty(firstName);
//        this.hireDate = new SimpleStringProperty(hireDate);
//        this.enrollmentDate = new SimpleStringProperty(enrollmentDate);
//    }
//    public Person(){}
//
//
//    public int getPersonID() {
//        return personID.get();
//    }
//
//    public IntegerProperty personIDProperty() {
//        return personID;
//    }
//
//    public void setPersonID(int personID) {
//        this.personID.set(personID);
//    }
//
//    public String getLastName() {
//        return lastName.get();
//    }
//
//    public StringProperty lastNameProperty() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName.set(lastName);
//    }
//
//    public String getFirstName() {
//        return firstName.get();
//    }
//
//    public StringProperty firstNameProperty() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName.set(firstName);
//    }
//
//    public String getHireDate() {
//        return hireDate.get();
//    }
//
//    public StringProperty hireDateProperty() {
//        return hireDate;
//    }
//
//    public void setHireDate(String hireDate) {
//        this.hireDate.set(hireDate);
//    }
//
//    public String getEnrollmentDate() {
//        return enrollmentDate.get();
//    }
//
//    public StringProperty enrollmentDateProperty() {
//        return enrollmentDate;
//    }
//
//    public void setEnrollmentDate(String enrollmentDate) {
//        this.enrollmentDate.set(enrollmentDate);
//    }
//}

