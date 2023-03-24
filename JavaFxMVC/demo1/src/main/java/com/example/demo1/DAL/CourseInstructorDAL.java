package com.example.demo1.DAL;

import com.example.demo1.connect.ConnectionDB;
import com.example.demo1.models.CIConvert;
import com.example.demo1.models.Course;
import com.example.demo1.models.CourseInstructor;
import com.example.demo1.models.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseInstructorDAL extends ConnectionDB {
    public CourseInstructorDAL(){
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

    public List<CIConvert> getCourseInstructor(){
        List<CIConvert> ciCoverts = new ArrayList<>();
        try {
            String query = "SELECT * FROM school.course JOIN school.courseinstructor ON school.course.CourseID = school.courseinstructor.CourseID JOIN school.person ON school.person.PersonID = school.courseinstructor.PersonID";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                Person person = new Person();
                Course course = new Course();
                CIConvert ciCovert = new CIConvert();
                person.setPersonID(rs.getInt("personID"));
                person.setEnrollmentDate(rs.getString("enrollmentDate"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setHireDate(rs.getString("hireDate"));
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartmentID(rs.getInt("DepartmentID"));
                ciCovert.setCourse(course);
                ciCovert.setPerson(person);
                ciCoverts.add(ciCovert);
            }
        }catch (SQLException e){
//            System.out.println("Error get Course Instructor");
            System.out.println(e);
        }
//        for (CIConvert c: ciCoverts) {
//            System.out.println(c.getCourse().getCourseID()+"---"+c.getPerson().getPersonID());
//        }
        return ciCoverts;
    }

    public int deleteCourseInstructor (CourseInstructor courseInstructor){
        int valueOfResult = 0;
        try {
            String query = "DELETE FROM `school`.`courseinstructor` WHERE (`CourseID` = ?) and (`PersonID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseInstructor.getCourseID());
            preparedStatement.setInt(2, courseInstructor.getPersonID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error delete course instructor");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    public int insertCourseInstructor (CourseInstructor courseInstructor){
        int valueOfResult = 0;
        try {
            String query = "INSERT INTO `school`.`courseinstructor` (`CourseID`, `PersonID`) VALUES (?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseInstructor.getCourseID());
            preparedStatement.setInt(2, courseInstructor.getPersonID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error insert course instructor");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    public int updateCourseInstructor (CourseInstructor oldCourseInstructor, CourseInstructor newCourseInstructor){
        int valueOfResult = 0;
        try {
            String query = "UPDATE `school`.`courseinstructor` SET `CourseID` = ?, `PersonID` = ? WHERE (`CourseID` = ?) and (`PersonID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, newCourseInstructor.getCourseID());
            preparedStatement.setInt(2, newCourseInstructor.getPersonID());
            preparedStatement.setInt(3, oldCourseInstructor.getCourseID());
            preparedStatement.setInt(4, oldCourseInstructor.getPersonID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error update course instructor");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }
    public static void main(String[] args) {
        CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
        courseInstructorDAL.getCourseInstructor();
//        CourseInstructor courseInstructor = new CourseInstructor(222,121);
//        CourseInstructor oldCourseInstructor = new CourseInstructor(12321,1111);
//        CourseInstructor newCourseInstructor = new CourseInstructor(9999,9999);
//        courseInstructorDAL.insertCourseInstructor(courseInstructor);
//        courseInstructorDAL.deleteCourseInstructor(courseInstructor);
//        courseInstructorDAL.updateCourseInstructor(oldCourseInstructor,newCourseInstructor);
    }
}
