package com.example.monsterhuntertalismanmanager;

import java.sql.*;

public class DatabaseConnection {
    public static void database(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/monster_hunter_talisman", "root", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from skills");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (
                SQLException e){
            e.printStackTrace();
        }
    }

}
