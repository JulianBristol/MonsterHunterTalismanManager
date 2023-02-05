package com.monsterhunter.model;

public class MHCharacter {
    //should be able to create, read, update, and delete characters from the database
    private String name;
    private int characterId;
    private int isMain;
    public MHCharacter(String name, int isMain){
        this.name = name;
        this.isMain = isMain;
    }
    public MHCharacter(int characterId, String name, int isMain){
        this.characterId = characterId;
        this.name = name;
        this.isMain = isMain;
    }

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

    public int isMain() {
        return isMain;
    }

    public void setMain(int main) {
        isMain = main;
    }

    public String toString(){
        String isMain = this.isMain == 1 ? "True" : "False";
        return "CharacterId: " + this.characterId + "\nCharacter Name: " + this.name + "\nIs designated as Main Character: " + isMain;
    }

    //need to return a Character object by characterId
}
