package com.example.javagame;
import javafx.application.Application;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.HashMap;

import static com.example.javagame.GameConfig.*;


public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("java game");
        stage.show();
        makeGameData();
    }

    public static void main(String[] args) {
        launch();
    }
}