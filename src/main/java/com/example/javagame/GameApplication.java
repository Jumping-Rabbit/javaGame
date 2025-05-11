package com.example.javagame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Instant;


public class GameApplication extends Application {
    @Override
    public void start(Stage stage) {
        double widthScale = (Screen.getPrimary().getBounds().getWidth() * Screen.getPrimary().getOutputScaleX()) / 1280;
        double heightScale = (Screen.getPrimary().getBounds().getHeight() * Screen.getPrimary().getOutputScaleY()) / 720;
        double canvasScale = Math.min(widthScale, heightScale);
        Canvas canvas = new Canvas(1280 * canvasScale, 720 * canvasScale);
        GraphicsContext graphics_context = canvas.getGraphicsContext2D();
        Group group = new Group(canvas);
        Scene scene = new Scene(group, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        scene.setFill(Color.rgb(0, 0, 0));

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(screenBounds.getMinX());
        stage.setY(screenBounds.getMinY());
        stage.setWidth(screenBounds.getWidth());
        stage.setHeight(screenBounds.getHeight());
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        stage.setTitle("java game");
        Platform.runLater(() -> {
            new Thread(() -> {
                long frameCountStartTime = Instant.now().toEpochMilli();
                int frameCount = 0;
                long fps = 0;
                while (true) {
                    frameCount ++;
                    long currentFrameTime = Instant.now().toEpochMilli();
                    long timePassed = currentFrameTime - frameCountStartTime;
                    if (timePassed > 2000) {
                        fps = frameCount * 1000L / timePassed;
                        System.out.println(fps);
                        frameCount = 0;
                        frameCountStartTime = currentFrameTime;
                    }
                    graphics_context.clearRect(0, 0, 1280 * canvasScale, 720 * canvasScale);
                    graphics_context.setFill(Color.WHITE);
                    graphics_context.fillRect(0, 0, 1280 * canvasScale, 720 * canvasScale);
                    graphics_context.setFill(Color.RED);
                    graphics_context.fillRect(20, 20, 70, 70);
                    graphics_context.setFill(Color.BLUE);
                    graphics_context.fillOval(30, 30, 70, 70);
                    graphics_context.setFill(Color.BLACK);
                    graphics_context.fillText("fps: " + fps, 10 * canvasScale, 10 * canvasScale);
                }
            }).start();
        });
    }
    public static void main(String[] args) {
        launch();
    }
}