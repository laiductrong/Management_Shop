package com.example.demo1.DAL;

import com.example.demo1.connect.ConnectionDB;
import com.example.demo1.models.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAL extends ConnectionDB {
    public CourseDAL(){
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

    public List<Course> getCourses(){
        List<Course> courses  = new ArrayList<>();
        try {
            String query = "SELECT * FROM school.course";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                Course course = new Course();

                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));

                courses.add(course);
            }
        }catch (SQLException e){
            System.out.println("error get courses");
        }
//        for (Course c: courses) {
//            System.out.println(c.getCourseID()+"--"+c.getTitle()+"--"+c.getCredits()+"--"+c.getDepartmentID());
//        }
        return courses;
    }

    public int updateCourse(Course course){
//        Person person = new Person(1,"last name change","first name change",null,null);
        int valueOfResult = 0;
        try{
            String query = "UPDATE `school`.`course` SET `Title` = ?, `Credits` = ?, `DepartmentID` = ? WHERE (`CourseID` = ?)";
            // "UPDATE Course SET Title = ?, Credits = ?, DepartmentID = ?" + "WHERE CourseID = ?";

            PreparedStatement preparedStatement = this.connection.prepareStatement(query);

            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setInt(2,course.getCredits());
            preparedStatement.setInt(3,course.getDepartmentID());
            preparedStatement.setInt(4, course.getCourseID());

            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error update course");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    public int insertCourse (Course course){
        int valueOfResult = 0;
        try{
            String query = "INSERT INTO `school`.`course` (`CourseID`, `Title`, `Credits`, `DepartmentID`) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,course.getCourseID());
            preparedStatement.setString(2,course.getTitle());
            preparedStatement.setInt(3,course.getCredits());
            preparedStatement.setInt(4,course.getDepartmentID());
            valueOfResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insert course");
        }
        return valueOfResult;
    }

    public int deleteCourse (int courseID){
        int valueOfResult = 0;
        try {
            String query = "DELETE FROM `school`.`course` WHERE (`CourseID` = ?);";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,courseID);
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error delete course");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    public List<Course> findCourse(String name){
        List<Course> courses = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.course WHERE Title LIKE"+"'%"+name+"%'";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                Course course = new Course();
                course.setCourseID(rs.getInt("courseID"));
                course.setTitle(rs.getString("title"));
                course.setCredits(rs.getInt("credits"));
                course.setDepartmentID(rs.getInt("departmentID"));
                courses.add(course);
            }
        }catch (SQLException e){
            System.out.println("Error find Person");
        }
        for (Course c: courses) {
            System.out.println(c.getTitle());
        }
        return courses;
    }

    public static void main(String[] args) {
        Course course = new Course(1123, "title insert", 3, 1);
        CourseDAL courseDAL = new CourseDAL();
        courseDAL.getCourses();
//        courseDAL.updateCourse(course);
//        courseDAL.insertCourse(course);
//        courseDAL.deleteCourse(course.getCourseID());
//        courseDAL.findCourse("om");
    }

}
