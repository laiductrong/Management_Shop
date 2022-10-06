package com.example.demo1.BLL;

import com.example.demo1.DAL.CourseInstructorDAL;
import com.example.demo1.models.CourseInstructor;

public class CourseIntructorBLL {
    CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    public boolean checkInsert(CourseInstructor courseInstructor){
        courseInstructorDAL.insertCourseInstructor(courseInstructor);
        return true;
    }
    public boolean checkUpdate(CourseInstructor oldCourseInstructor, CourseInstructor newCourseInstructor){
        courseInstructorDAL.updateCourseInstructor(oldCourseInstructor, newCourseInstructor);
        return true;
    }
    public boolean checkDelete(CourseInstructor courseInstructor){
        courseInstructorDAL.deleteCourseInstructor(courseInstructor);
        return true;
    }
}
