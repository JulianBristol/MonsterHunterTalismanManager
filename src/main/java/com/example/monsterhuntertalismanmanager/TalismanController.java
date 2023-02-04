package com.example.monsterhuntertalismanmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TalismanController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}