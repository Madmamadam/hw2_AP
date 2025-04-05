package org.example.test_hw2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Pane root = new Pane();
        root= fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();

        circle1.setRadius(10);
        circle1.setCenterX(50);
        circle1.setCenterY(50);
        circle1.setFill(Color.RED);
        circle2.setRadius(10);
        circle2.setCenterX(60);
        circle2.setCenterY(50);
        circle2.setFill(Color.BLUE);
        //root.getChildren().addAll(circle1, circle2);
//        stage.setHeight(200);
//        stage.setWidth(200);
        stage.setTitle("Hello World");
        stage.show();
    }
}