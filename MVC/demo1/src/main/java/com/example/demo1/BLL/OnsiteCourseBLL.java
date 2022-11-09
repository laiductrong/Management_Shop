package com.example.demo1.BLL;

import com.example.demo1.DAL.OnsiteCourseDAL;
import com.example.demo1.models.OnsiteCourse;

import java.time.LocalTime;

public class OnsiteCourseBLL {
    //Time: 13:15:00
    OnsiteCourseDAL onsiteCourseDAL = new OnsiteCourseDAL();
    public boolean checkInsert(OnsiteCourse onsiteCourse){
//        OnsiteCourse onsiteCourse2 = new OnsiteCourse(3141, "dsad", "TH", "11:15:00");
        try{
            if(!onsiteCourse.getTime().equals(""))
            {
                LocalTime myObj = LocalTime.parse(onsiteCourse.getTime());
            }
            if(onsiteCourseDAL.insertOnsiteCourse(onsiteCourse)==1)
                return true;
            else
                return false;
        }catch (Exception e){
            return false;
        }

    }
    public boolean checkUpdate (OnsiteCourse onsiteCourse){
        try{
            if(!onsiteCourse.getTime().equals(""))
            {
                LocalTime myObj = LocalTime.parse(onsiteCourse.getTime());
            }
            if(onsiteCourseDAL.updateOnsiteCourse(onsiteCourse)==1){
                return true;
            }else
                return false;
        }catch (Exception e){
            return false;
        }
    }
    public boolean checkDelete (Integer idDelete){
        if(onsiteCourseDAL.deleteOnsiteCourse(idDelete)==1)
            return true;
        else
            return false;
    }
}
