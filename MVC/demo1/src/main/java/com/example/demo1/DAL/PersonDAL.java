package com.example.demo1.DAL;

import com.example.demo1.connect.ConnectionDB;
import com.example.demo1.models.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAL extends ConnectionDB {
    public PersonDAL(){
        super();
        this.getConnect();
    }

    @Override
    public void getConnect() {
        super.getConnect();
    }

    @Override
    public ResultSet doReadQuery(String sql) {
        return super.doReadQuery(sql);
    }


    public List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        try {
            String query = "SELECT * FROM school.person";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                Person person = new Person();
                person.setPersonID(rs.getInt("personID"));
                person.setEnrollmentDate(rs.getString("enrollmentDate"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setHireDate(rs.getString("hireDate"));
                persons.add(person);
            }
        }catch (SQLException e){
            System.out.println("error get person");
        }
        for (Person p: persons) {
            System.out.println(p.getFirstName());
        }
        return persons;
    }
    public int updatePerson(Person person){
//        Person person = new Person(1,"last name change","first name change",null,null);
        int valueOfResult = 0;
        try{
            String query = "Update Person SET FirstName = ? , LastName = ? " + " WHERE PersonID = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getPersonID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error update person");
        }
//        System.out.println(valueOfResult);
        return valueOfResult;
    }
    public int insertPerson (Person person){
        int valueOfResult = 0;
        try{
           String query = "INSERT INTO `school`.`person` (`Lastname`, `Firstname`, `HireDate`, `EnrollmentDate`) VALUES ( ?, ?, ?, ?)";
           PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//           preparedStatement.setInt(1,person.getPersonID());
           preparedStatement.setString(1,person.getLastName());
           preparedStatement.setString(2,person.getFirstName());
           preparedStatement.setString(3,person.getHireDate());
           preparedStatement.setString(4,person.getEnrollmentDate());
           valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error insert person");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }
    public int deletePerson (int personID){
        int valueOfResult = 0;
        try {
            String query = "DELETE FROM `school`.`person` WHERE (`PersonID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,personID);
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error delete person");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }
    public List<Person> findPerson(String name){
        List<Person> persons = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.person WHERE FirstName OR LastName LIKE "+"'%"+name+"%'";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                Person person = new Person();
                person.setPersonID(rs.getInt("personID"));
                person.setEnrollmentDate(rs.getString("enrollmentDate"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setHireDate(rs.getString("hireDate"));
                persons.add(person);
            }
        }catch (SQLException e){
            System.out.println("Error find Person");
        }
        for (Person p: persons) {
            System.out.println(p.getFirstName());
        }
        return persons;
    }

    public static void main(String[] args) {
        PersonDAL personDAL = new PersonDAL();
        Person person = new Person(null,"LN","FN",null,null);
//        personDAL.getPersons();
//        personDAL.updatePerson();
        personDAL.insertPerson(person);
//        personDAL.deletePerson(person.personID);
//        personDAL.findPerson("giong");
    }
}
