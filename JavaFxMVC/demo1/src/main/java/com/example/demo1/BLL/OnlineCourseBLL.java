package com.example.demo1.BLL;

import com.example.demo1.DAL.OnlineCourseDAL;
import com.example.demo1.models.OnlineCourse;

public class OnlineCourseBLL {
    OnlineCourseDAL onlineCourseDAL = new OnlineCourseDAL();
    public boolean checkInsert (OnlineCourse onlineCourse){
        if(onlineCourseDAL.insertOnlineCourse(onlineCourse)==1)
            return true;
        else
            return false;
    }
    public boolean checkUpdate(OnlineCourse onlineCourse){
        if(onlineCourse.getUrl().equals("")){
            return false;
        }
        else if(onlineCourseDAL.updateOnlineCourse(onlineCourse)==1){
            return true;
        }
        return false;
    }
    public boolean checkDelete(Integer idDelete){
        if(onlineCourseDAL.deleteOnlineCourse(idDelete)==1)
            return true;
        else
            return false;
    }
}
