package org.example.test_hw2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        double central_y=200;
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
//        Pane root = new Pane();
        Pane gamepane = new Pane();
//        root= fxmlLoader.load();
//        Scene scene = new Scene(root);
        Scene gamescene = new Scene(gamepane);
        stage.setScene(gamescene);
        Polygon esgh = new Polygon();
        esgh.setFill(Color.BLACK);
        esgh.getPoints().addAll(
                150.0, 50.0,    // First point
                250.0, 50.0,   // Second point
                200.0, 150.0   // Third point
        );
        esgh.setFill(Color.BLACK);
        gamepane.getChildren().add(esgh);


        stage.setHeight(800);
        stage.setWidth(1200);
        AnimationTimer animationTimer = new AnimationTimer() {

            @Override
            public void handle(long l) {
                esgh.setScaleX(esgh.getScaleX() + 0.001);

            }
        };
        animationTimer.start();



        stage.setTitle("Hello World");
        stage.show();
    }
}