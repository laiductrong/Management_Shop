package com.example.demo1.BLL;

import com.example.demo1.DAL.OnsiteCourseDAL;
import com.example.demo1.models.OnsiteCourse;

import java.time.LocalTime;

public class OnsiteCourseBLL {
    //Time: 13:15:00
    OnsiteCourseDAL onsiteCourseDAL = new OnsiteCourseDAL();
    public boolean checkInsert(OnsiteCourse onsiteCourse){
        try{
            LocalTime myObj = LocalTime.parse(onsiteCourse.getTime());
            onsiteCourseDAL.insertOnsiteCourse(onsiteCourse);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean checkUpdate (OnsiteCourse onsiteCourse){
        try{
            LocalTime myObj = LocalTime.parse(onsiteCourse.getTime());
            onsiteCourseDAL.updateOnsiteCourse(onsiteCourse);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean checkDelete (Integer idDelete){
        onsiteCourseDAL.deleteOnsiteCourse(idDelete);
        return true;
    }
}
