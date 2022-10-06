package com.example.demo1.BLL;

import com.example.demo1.DAL.OnlineCourseDAL;
import com.example.demo1.models.OnlineCourse;

public class OnlineCourseBLL {
    OnlineCourseDAL onlineCourseDAL = new OnlineCourseDAL();
    public boolean checkInsert (OnlineCourse onlineCourse){
        onlineCourseDAL.insertOnlineCourse(onlineCourse);
        return true;
    }
    public boolean checkUpdate(OnlineCourse onlineCourse){
        onlineCourseDAL.updateOnlineCourse(onlineCourse);
        return true;
    }
    public boolean checkDelete(Integer idDelete){
        onlineCourseDAL.deleteOnlineCourse(idDelete);
        return true;
    }
}
