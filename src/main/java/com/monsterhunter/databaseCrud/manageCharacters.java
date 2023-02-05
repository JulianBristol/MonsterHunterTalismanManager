package com.monsterhunter.databaseCrud;

import com.monsterhunter.DatabaseConnection;
import com.monsterhunter.model.MHCharacter;

import java.sql.*;

public class manageCharacters {
    private static final String SQL_CREATE_STMT = "INSERT INTO characters (name, isMain) VALUES (?, ?)";
    private static final String SQL_READ = "SELECT * FROM characters WHERE characterId = ?";
    public void insertCharacter(MHCharacter character){
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SQL_CREATE_STMT);
            prepStmt.setString(1, character.getName());
            prepStmt.setInt(2, character.isMain());
            prepStmt.execute();
            System.out.println("Character inserted");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Failed to insert a character into the database");
        }
    }

    /*public void updateCharacter(int characterId, MHCharacter character){

    }*/

    public MHCharacter getCharacter(int characterId) throws NullPointerException{
        MHCharacter character = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SQL_READ);
            prepStmt.setInt(1, characterId);
            ResultSet resultSet = prepStmt.executeQuery();
            while(resultSet.next()){
                character = new MHCharacter(resultSet.getInt("characterId"), resultSet.getString("name"), resultSet.getInt("isMain"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve character information from the database");
        }
        return character;
    }

    /*public void deleteCharacter(int characterId){

    }*/
}
