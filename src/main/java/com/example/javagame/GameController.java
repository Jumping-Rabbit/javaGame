package com.example.javagame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label inDevelopment;

    @FXML
    protected void onNewGameClick() {
        inDevelopment.setText("feature in development");
    }

    protected void onSaveGameClick() {
        inDevelopment.setText("feature in development");
    }

    protected void onLoadGameClick() {
        inDevelopment.setText("feature in development");
    }

    protected void onSettingsClick() {
        inDevelopment.setText("feature in development");
    }
}