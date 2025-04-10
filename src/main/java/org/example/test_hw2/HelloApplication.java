package org.example.test_hw2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        Constant cons = Constant.getinstance();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
//        Pane root = new Pane();
        Pane gamepane = new Pane();
//        root= fxmlLoader.load();
//        Scene scene = new Scene(root);
        Scene gamescene = new Scene(gamepane);
        stage.setScene(gamescene);
        Circle circle = new Circle();
        circle.setFill(Color.BLUE);
        circle.setRadius(10);
        circle.setCenterX(cons.getCENTRAL_X());
        circle.setCenterY(cons.getCENTRAL_Y());
        gamepane.getChildren().add(circle);


        Polygon testtrap=Shaapes.new_trap_polygon(200,0.0);
        testtrap.setFill(Color.BLACK);
        gamepane.getChildren().add(testtrap);
        Polygon testtrap2 =Shaapes.new_trap_polygon(200,60.0);
        testtrap2.setFill(Color.BLACK);
        gamepane.getChildren().add(testtrap2);



        stage.setHeight(800);
        stage.setWidth(1200);
//        AnimationTimer animationTimer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                esgh.setScaleX(esgh.getScaleX() + 0.001);
//
//            }
//        };
//        animationTimer.start();



        stage.setTitle("Hello World");
        stage.show();
    }
}