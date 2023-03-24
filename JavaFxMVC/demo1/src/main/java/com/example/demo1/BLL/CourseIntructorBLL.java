package com.example.demo1.BLL;

import com.example.demo1.DAL.CourseInstructorDAL;
import com.example.demo1.models.CourseInstructor;

public class CourseIntructorBLL {
    CourseInstructorDAL courseInstructorDAL = new CourseInstructorDAL();
    public boolean checkInsert(CourseInstructor courseInstructor){
        if(courseInstructorDAL.insertCourseInstructor(courseInstructor)==1)
            return true;
        else
            return false;
    }
    public boolean checkUpdate(CourseInstructor oldCourseInstructor, CourseInstructor newCourseInstructor){
        if(courseInstructorDAL.updateCourseInstructor(oldCourseInstructor, newCourseInstructor)==1)
            return true;
        else
            return false;
    }
    public boolean checkDelete(CourseInstructor courseInstructor){
        if(courseInstructorDAL.deleteCourseInstructor(courseInstructor)==1)
            return true;
        else
            return false;
    }
}
