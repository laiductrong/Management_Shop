package com.example.demo1.DAL;

import com.example.demo1.connect.ConnectionDB;
import com.example.demo1.models.Course;
import com.example.demo1.models.Person;
import com.example.demo1.models.SGConvert;
import com.example.demo1.models.StudentGrade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentGradeDAL extends ConnectionDB {
    public StudentGradeDAL(){
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

    public List<SGConvert> getStudentGrade(){
        List<SGConvert> sgConverts = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.studentgrade JOIN school.person ON school.studentgrade.StudentID = school.person.PersonID JOIN school.course ON school.studentgrade.CourseID = school.course.CourseID";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                Person person = new Person();
                Course course = new Course();
                SGConvert sgConvert = new SGConvert();
                person.setPersonID(rs.getInt("personID"));
                person.setEnrollmentDate(rs.getString("enrollmentDate"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setHireDate(rs.getString("hireDate"));
                course.setCourseID(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setCourseID(rs.getInt("DepartmentID"));
                sgConvert.setPerson(person);
                sgConvert.setCourse(course);
                sgConvert.setEnrollmentID(rs.getInt("EnrollmentID"));
                sgConvert.setGrade(rs.getString("Grade"));
                sgConverts.add(sgConvert);
            }
        }catch (SQLException e){
            System.out.println("Error get student grade");
        }
        for (SGConvert s:sgConverts) {
//            System.out.println(s.getEnrollmentID()+"---"+s.getCourse().getTitle()+"---"+s.getPerson().getLastName()+"---"+s.getGrade());
//            System.out.println(s.getCourse().getCourseID());
            System.out.println(s.getCourse().getCourseID());
        }
        return sgConverts;
    }

    public int insertStudentGrade(StudentGrade studentGrade){
        int valueOfResult = 0;
        try{
            String query = "INSERT INTO `school`.`studentgrade` (`CourseID`, `StudentID`, `Grade`) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,studentGrade.getCourseID());
            preparedStatement.setInt(2,studentGrade.getStudentID());
            preparedStatement.setString(3,studentGrade.getGrade());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error insert student grade");
        }
        return valueOfResult;
    }

    public int updateStudentGrade(StudentGrade studentGrade){
        int valueOfResult = 0;
        try{
            String query = "UPDATE `school`.`studentgrade` SET `CourseID` = ?, `StudentID` = ?, `Grade` = ? WHERE (`EnrollmentID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,studentGrade.getCourseID());
            preparedStatement.setInt(2,studentGrade.getStudentID());
            preparedStatement.setString(3,studentGrade.getGrade());
            preparedStatement.setInt(4,studentGrade.getEnrollmentID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error update student grade");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    public int deleteStudentGrade(int enrollmentID){
        int valueOfResult = 0;
        try {
            String query = "DELETE FROM `school`.`studentgrade` WHERE (`EnrollmentID` = "+enrollmentID+")";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error delete student grade");
        }
        return valueOfResult;
    }

    public static void main(String[] args) {
        StudentGradeDAL studentGradeDAL = new StudentGradeDAL();
        studentGradeDAL.getStudentGrade();
//        StudentGrade studentGrade = new StudentGrade(null,1024,24,"2.40");
//        studentGradeDAL.insertStudentGrade(studentGrade);
////        studentGradeDAL.updateStudentGrade(studentGrade);
////        studentGradeDAL.deleteStudentGrade(studentGrade.getEnrollmentID());
    }
}
