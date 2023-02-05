package com.monsterhunter.databaseCrud;

import com.monsterhunter.DatabaseConnection;
import com.monsterhunter.model.MHCharacter;

import java.sql.*;

public class manageCharacters {
    private static final String SQL_CREATE_STMT = "INSERT INTO characters (name, isMain) VALUES (?, ?)";
    private static final String SQL_READ = "SELECT * FROM characters";
    private static final String SQL_SELECT = "SELECT * FROM characters WHERE characterId = ?";
    private static final String SQL_UPDATE = "UPDATE characters SET name = ?, isMain = ? WHERE characterId = ?";
    private static final String SQL_DELETE_STMT = "DELETE FROM characters WHERE characterId = ?";
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

    public void updateCharacter(int characterId, String name, int isMain) throws NullPointerException{
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            if (getCharacter(characterId) == null){
                throw new NullPointerException();
            }
            PreparedStatement prepStmt = connection.prepareStatement(SQL_UPDATE);
            prepStmt.setString(1, name);
            prepStmt.setInt(2, isMain);
            prepStmt.setInt(3, characterId);
            prepStmt.execute();
            System.out.println("Character updated");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Failed to update characterID " + characterId + " in the database");
        }
    }

    public MHCharacter getCharacter(int characterId) throws NullPointerException{
        MHCharacter character = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SQL_SELECT);
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

    public String getAllCharacters(){
        StringBuilder sb = new StringBuilder();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL_READ);
            while(resultSet.next()){
                sb.append("\n\n");
                sb.append((new MHCharacter(resultSet.getInt("characterId"), resultSet.getString("name"), resultSet.getInt("isMain"))).toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve any characters from the database");
        }
        return sb.toString();
    }

    public void deleteCharacter(int characterId){
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SQL_DELETE_STMT);
            prepStmt.setInt(1, characterId);
            prepStmt.execute();
            System.out.println("Character deleted");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Failed to delete the character with a characterId of " + characterId);
        }
    }
}
