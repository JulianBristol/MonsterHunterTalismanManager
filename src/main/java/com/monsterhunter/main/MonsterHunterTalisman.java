package com.monsterhunter.main;

        import com.monsterhunter.databaseCrud.manageCharacters;
        import com.monsterhunter.model.MHCharacter;
        /*import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;*/
        import java.util.Scanner;

public class MonsterHunterTalisman /*extends Application */{
    /*@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MonsterHunterTalisman.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("Monster Hunter Talisman Manager");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
        /*launch();*/

        manageCharacters dbCrud = new manageCharacters();

        //Command Line Interface
        try(Scanner input = new Scanner(System.in)){
            boolean running = true;
            while(running){

                System.out.println("\n\nMake a selection");
                System.out.println("1. Create a new character");
                System.out.println("2. Display all characters");
                System.out.println("3. Select a character by their characterId");
                System.out.println("4. Update a character");
                System.out.println("5. Delete a character");
                System.out.println("6. Exit");

                try{
                    int selection = Integer.parseInt(input.nextLine());

                    switch (selection) {

                        case 1 -> {
                            System.out.println("Enter the character name");
                            String characterName = input.nextLine();
                            System.out.println("Make this character your main character?\nEnter 1 for yes and 2 for no");
                            int userResponse = Integer.parseInt(input.nextLine());
                            switch (userResponse){
                                case 1 -> userResponse = 1;
                                case 2 -> userResponse = 0;
                                default -> {
                                    break;
                                }
                            }
                            MHCharacter newMHCharacter = new MHCharacter(characterName, userResponse);
                            dbCrud.insertCharacter(newMHCharacter);
                        }

                        case 2 -> System.out.println("you selected 2");

                        case 3 -> {
                            System.out.println("Enter the characterId");
                            int charSelection = Integer.parseInt(input.nextLine());
                            MHCharacter character = dbCrud.getCharacter(charSelection);
                            System.out.println("Character information:");
                            System.out.println(character.toString());
                        }

                        case 4 -> System.out.println("you selected 4");
                        case 5 -> System.out.println("you selected 5");
                        case 6 -> {
                            System.out.println("You chose to terminate the application");
                            running = false;
                        }
                        default -> System.out.println("Invalid selection\nPlease try again");
                    }
                } catch(NumberFormatException numE){
                    System.out.println("Invalid input entered\nPlease try again");
                } catch (NullPointerException nullPointer){
                    System.out.println("The selected character does not exist within the database");
                }
            }
        }

    }
}