package com.example.demo1.DAL;

import com.example.demo1.connect.ConnectionDB;
import com.example.demo1.models.OnsiteCourse;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OnsiteCourseDAL extends ConnectionDB {
    public OnsiteCourseDAL() {
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

    public List<OnsiteCourse> getOnsiteCourse() {
        List<OnsiteCourse> onsiteCourses = new ArrayList<>();
        try {
            String query = "SELECT * FROM school.onsitecourse";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()) {
                OnsiteCourse onsiteCourse = new OnsiteCourse();
                onsiteCourse.setCourseID(rs.getInt("courseID"));
                onsiteCourse.setDays(rs.getString("days"));
                onsiteCourse.setLocation(rs.getString("location"));
                onsiteCourse.setTime(rs.getString("time"));
                onsiteCourses.add(onsiteCourse);
            }
        } catch (SQLException e) {
            System.out.println("Error get onsite course");
        }
        for (OnsiteCourse o : onsiteCourses) {
            System.out.println(o.getCourseID());
        }
        return onsiteCourses;
    }

    //insert
    public int insertOnsiteCourse(OnsiteCourse onsiteCourse) {
        int valueOfResult = 0;
        try {
            String query = "INSERT INTO `school`.`onsitecourse` (`CourseID`, `Location`, `Days`, `Time`) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, onsiteCourse.getCourseID());
            preparedStatement.setString(2, onsiteCourse.getLocation());
            preparedStatement.setString(3, onsiteCourse.getDays());
            preparedStatement.setString(4, onsiteCourse.getTime());
            valueOfResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insert onsite course");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }

    //DELETE FROM `school`.`onsitecourse` WHERE (`CourseID` = '5555');
    public int deleteOnsiteCourse(int courseID) {
        int valueOfResult = 0;
        try {
            String query = "DELETE FROM `school`.`onsitecourse` WHERE (`CourseID` = " + courseID + ")";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            valueOfResult = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error delete onsite course");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }
    //update
    public int updateOnsiteCourse(OnsiteCourse onsiteCourse) {
        int valueOfResult = 0;
        try {
            String query = "UPDATE `school`.`onsitecourse` SET `Location` = ?, `Days` = ?, `Time` = ? WHERE (`CourseID` = ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1,onsiteCourse.getLocation());
            preparedStatement.setString(2,onsiteCourse.getDays());
            preparedStatement.setString(3,onsiteCourse.getTime());
            preparedStatement.setInt(4,onsiteCourse.getCourseID());
            valueOfResult = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error update onsite course");
        }
        System.out.println(valueOfResult);
        return valueOfResult;
    }
    public List<OnsiteCourse> findOnsiteCourseLocation(String key){
        List<OnsiteCourse> onsiteCourses = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.onsitecourse WHERE Location LIKE '%"+key+"%';";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()) {
                OnsiteCourse onsiteCourse = new OnsiteCourse();
                onsiteCourse.setCourseID(rs.getInt("courseID"));
                onsiteCourse.setDays(rs.getString("days"));
                onsiteCourse.setLocation(rs.getString("location"));
                onsiteCourse.setTime(rs.getString("time"));
                onsiteCourses.add(onsiteCourse);
            }
        }catch (SQLException e){
            System.out.println("Error find onsite course");
        }
        for (OnsiteCourse o : onsiteCourses) {
            System.out.println(o.getCourseID());
        }
        return onsiteCourses;
    }
    public List<OnsiteCourse> findOnsiteCourseDays(String key){
        List<OnsiteCourse> onsiteCourses = new ArrayList<>();
        try{
            String query = "SELECT * FROM school.onsitecourse WHERE Days LIKE '%"+key+"%';";
            ResultSet rs = this.doReadQuery(query);
            while (rs.next()) {
                OnsiteCourse onsiteCourse = new OnsiteCourse();
                onsiteCourse.setCourseID(rs.getInt("courseID"));
                onsiteCourse.setDays(rs.getString("days"));
                onsiteCourse.setLocation(rs.getString("location"));
                onsiteCourse.setTime(rs.getString("time"));
                onsiteCourses.add(onsiteCourse);
            }
        }catch (SQLException e){
            System.out.println("Error find onsite course");
        }
        for (OnsiteCourse o : onsiteCourses) {
            System.out.println(o.getCourseID());
        }
        return onsiteCourses;
    }

    public static void main(String[] args) {
        OnsiteCourseDAL onsiteCourseDAL = new OnsiteCourseDAL();
        OnsiteCourse onsiteCourse = new OnsiteCourse(5555, "Location change", "DAYS", "14:22:00");
//        onsiteCourseDAL.getOnsiteCourse();
//        onsiteCourseDAL.insertOnsiteCourse(onsiteCourse);
//        onsiteCourseDAL.deleteOnsiteCourse(onsiteCourse.getCourseID());
//        onsiteCourseDAL.updateOnsiteCourse(onsiteCourse);
//        onsiteCourseDAL.findOnsiteCourseLocation("SMi");
//        onsiteCourseDAL.findOnsiteCourseDays("HH");
    }

}
