package com.monsterhunter;

import java.sql.*;

public class DatabaseConnection {
    public static String database(){
        StringBuilder returnStatement = new StringBuilder();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/monster_hunter_talisman", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from skills");
            while (resultSet.next()){
                /*System.out.println(resultSet.getString("name"));*/
                returnStatement.append(resultSet.getString("name"));
            }
            return returnStatement.toString();
        } catch (SQLException e){
            e.printStackTrace();
           return "There was an error while trying to access access the database.\n Ensure that you have entered the correction username and password for the database";
        }
    }

}
