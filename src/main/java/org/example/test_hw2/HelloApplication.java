package org.example.test_hw2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
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



        Shaapes.Type3 test = new Shaapes.Type3();
        test.update(250,0);
        for(int i =0; i<cons.getGAME_NUMBER()-1;i++)
        {
            gamepane.getChildren().add(test.trapezoids[i].polygon);
            test.trapezoids[i].polygon.setFill(Color.BLUE);
        }


        stage.setHeight(800);
        stage.setWidth(1200);
        stage.show();

//        AnimationTimer animationTimer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                test.update(test.getRadius()-0.2, test.getFirst_angle_in_degree()-0.5 );
//            }
//        };
//        animationTimer.start();




    }
}