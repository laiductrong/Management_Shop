package com.example.demo1.connect;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAL extends ConnectionDB {

    public TestDAL(){
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

    public void readStudents() throws SQLException{
        String query = "SELECT * FROM school.Person WHERE school.person.EnrollmentDate >0;";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()){
              System.out.println(rs.getString("Firstname"));
          }
    }
}
