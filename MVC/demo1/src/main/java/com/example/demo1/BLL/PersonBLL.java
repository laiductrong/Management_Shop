package com.example.demo1.BLL;

import com.example.demo1.DAL.PersonDAL;
import com.example.demo1.models.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PersonBLL {
    PersonDAL personDAL = new PersonDAL();
    public boolean checkInsert(Person person){
        try {
            if(person.getHireDate()!=null){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = person.getHireDate()+" 20:13:04";
                LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
            }
            if(person.getEnrollmentDate()!=null){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = person.getEnrollmentDate()+" 20:13:04";
                LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
            }
            if(personDAL.insertPerson(person)==1){
                return true;
            }
            else
                return false;
        }catch (DateTimeParseException e){
            return false;
        }
    }
    public boolean checkUpdate(Person person){
        try {
            if(person.getHireDate()!=null){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = person.getHireDate()+" 20:13:04";
                LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
            }
            if(person.getEnrollmentDate()!=null){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String date = person.getEnrollmentDate()+" 20:13:04";
                LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
            }
            if(personDAL.updatePerson(person)==1)
                return true;
            else
                return false;
        }catch (DateTimeParseException e){
            return false;
        }
    }
    public boolean checkDelete(Integer idPerson){
        if(personDAL.deletePerson(idPerson)==1)
            return true;
        else
            return false;
    }
}
