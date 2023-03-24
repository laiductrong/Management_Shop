package com.example.demo1.connect;

import java.sql.*;

public class ConnectionDB {
    public Connection connection;
    public Statement statement;
    public PreparedStatement preparedStatement;
    public String username = "root", password = "";
    public ConnectionDB(){

    }

    public void getConnect(){
        String dbPath = "jdbc:mysql://localhost:3306/school";
        try{
            connection = DriverManager.getConnection(dbPath,username,password);
            statement = connection.createStatement();
//            System.out.println("Connect");
        }catch (SQLException e){
            System.out.println("Error to get connect");
        }
    }
    public ResultSet doReadQuery(String sql){
        ResultSet resultSet = null;
        try{
            resultSet = statement.executeQuery(sql);
        }catch (SQLException e){
            System.out.println("Error to connect");
        }
        return resultSet;
    }
//    public Connection doWriteQuery(String query) throws SQLException {
//        String dbPath = "jdbc:mysql://localhost:3306/school";
//        connection = DriverManager.getConnection(dbPath,username,password);
//        PreparedStatement stmt = connection.prepareStatement(query);
//        return (Connection) connection;
//    }

//    public static void main(String[] args) throws SQLException {
//        new TestConnection().ConnectDB();
//    }

}
