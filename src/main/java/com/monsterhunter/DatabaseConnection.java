package com.monsterhunter;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/monster_hunter_talisman";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    public Connection getConnection() throws SQLException{
        /*StringBuilder returnStatement = new StringBuilder();
        try{*/
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            /*Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from skills");
            while (resultSet.next()){
                *//*System.out.println(resultSet.getString("name"));*//*
                returnStatement.append(resultSet.getString("name"));
            }
            return returnStatement.toString();
        } catch (SQLException e){
            e.printStackTrace();
           return "There was an error while trying to access access the database.\n Ensure that you have entered the correction username and password for the database";
        }*/
    }
}
