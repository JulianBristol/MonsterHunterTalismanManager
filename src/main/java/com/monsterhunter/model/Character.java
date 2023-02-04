package com.monsterhunter.model;

public class Character {
    //should be able to create, read, update, and delete characters from the database
    private String name;
    private int characterId;
    private boolean isMain;
    Character(int characterId, String name, boolean isMain){
        name = this.name;
        characterId = this.characterId;
        isMain = this.isMain;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
