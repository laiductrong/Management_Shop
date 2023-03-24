package com.example.demo1.DAL;

import com.example.demo1.connect.ConnectionDB;
import com.example.demo1.models.Course;
import com.example.demo1.models.OnlineCourse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OnlineCourseDAL extends ConnectionDB {
    public OnlineCourseDAL(){
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

    public List<OnlineCourse> getOnlineCourse(){
        List<OnlineCourse> onlineCourses = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.onlinecourse";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()){
                OnlineCourse onlineCourse = new OnlineCourse();
                onlineCourse.setCourseID(rs.getInt("courseID"));
                onlineCourse.setUrl(rs.getString("url"));
                onlineCourses.add(onlineCourse);
            }
        }catch (SQLException e){
            System.out.println("error get course");
        }
        for (OnlineCourse o : onlineCourses) {
            System.out.println(o.getCourseID());
        }
        return onlineCourses;
    }

    // quan he 1-1
    public int insertOnlineCourse (OnlineCourse onlineCourse){
        int valueOfResult = 0;
        try{
            String query = "INSERT INTO `school`.`onlinecourse` (`CourseID`, `url`) VALUES (?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,onlineCourse.getCourseID());
            preparedStatement.setString(2, onlineCourse.getUrl());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error insert Online Course");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    public OnlineCourse findOnlineCourse(Integer idOnlineCourse){
        OnlineCourse onlineCourse = new OnlineCourse();
        int countValue =0;
        try{
            String query = "SELECT * FROM `school`.`onlinecourse` WHERE CourseID = "+ idOnlineCourse;
//            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
//            preparedStatement.setInt(1, idOnlineCourse);
//            valueOfResult = preparedStatement.executeUpdate();
            ResultSet resultSet = this.doReadQuery(query);
            while (resultSet.next()){
                onlineCourse.setCourseID(resultSet.getInt("courseID"));
                onlineCourse.setUrl(resultSet.getString("url"));
                countValue++;
            }
            if (countValue!=0){
                System.out.println(onlineCourse.getUrl());
                return onlineCourse;
            }
        }catch (SQLException e){
            System.out.println("Error find online course");
        }
        return null;
    }

    //get list courseID not in table Online Course
    public List<Course> getCourseIDsNotInOC(){
        List<Course> courses = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.course WHERE CourseID NOT IN ( SELECT CourseID FROM school.onlinecourse ORDER BY CourseID)";
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
            System.out.println("Error get course online don't in course");
        }
//        for (Course c: courses) {
//            System.out.println(c.getTitle());
//        }
        return courses;
    }

    // delete
    public int deleteOnlineCourse (Integer onlineCourseID){
        int valueOfResult = 0;
        try {
            String query = "DELETE FROM `school`.`onlinecourse` WHERE (`CourseID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1,onlineCourseID);
            valueOfResult = preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Error insert online course");
        }
        return  valueOfResult;
    }

    //update
    public int updateOnlineCourse (OnlineCourse onlineCourse){
        int valueOfResult = 0;
        try {
            String query = "UPDATE `school`.`onlinecourse` SET `url` = ? WHERE (`CourseID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, onlineCourse.getUrl());
            preparedStatement.setInt(2, onlineCourse.getCourseID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error delete online course");
        }
        return valueOfResult;
    }

    public static void main(String[] args) {
        OnlineCourseDAL onlineCourseDAL = new OnlineCourseDAL();
        OnlineCourse onlineCourse = new OnlineCourse(4491,"http://www.fineartschool.net/Poetry");
//        onlineCourseDAL.getOnlineCourse();
//        onlineCourseDAL.insertOnlineCourse(onlineCourse);
//        onlineCourseDAL.findOnlineCourse(4491);
//        onlineCourseDAL.getCourseIDsNotInOC();
    }
}
