package com.example.demo1.BLL;

import com.example.demo1.DAL.StudentGradeDAL;
import com.example.demo1.models.StudentGrade;

public class StudentGradeBLL {
    StudentGradeDAL studentGradeDAL = new StudentGradeDAL();
    public boolean checkInsert(StudentGrade studentGrade){
        try{
            Float.parseFloat(studentGrade.getGrade());
            studentGradeDAL.insertStudentGrade(studentGrade);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public boolean checkUpdate(StudentGrade studentGrade){
        try{
            Float.parseFloat(studentGrade.getGrade());
            studentGradeDAL.updateStudentGrade(studentGrade);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean checkDelete(Integer idDelete){
        studentGradeDAL.deleteStudentGrade(idDelete);
        return true;
    }
}
