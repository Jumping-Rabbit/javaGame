package com.example.javagame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import java.io.IOException;
import javafx.scene.*;
import javafx.stage.StageStyle;

import java.lang.management.ManagementFactory;
import java.util.*;
import static com.example.javagame.GameConfig.*;
import static java.lang.Thread.sleep;


public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{
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
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
        stage.setTitle("java game");
        List<Long> frames = new ArrayList<>();
        Platform.runLater(() -> {
            new Thread(() -> {
                while (true) {
                    long frameStartTime = ManagementFactory.getRuntimeMXBean().getUptime();
                    frames.add(frameStartTime);

                    long lowMs = frames.getFirst();
                    for (int i = 0; i < frames.size(); i++) {
                        if (frameStartTime - frames.get(i) > 2000) {
                            frames.remove(i);
                        }
                    }
                    double fps = frames.size() / 2;
//                    System.out.println(fps);
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