package org.example.test_hw2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

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


//--------------------------------------------------------------------------------while
        ArrayList<Trapezoid> stack = new ArrayList<>();
        stack.add(new Trapezoid());
        AtomicInteger reverse = new AtomicInteger(0);
        Random rand = new Random();


        AnimationTimer animationTimer = new AnimationTimer() {
            @Override


            public void handle(long l) {
                if(stack.getLast().getRadius() <cons.getNEED_ADD_RADIUS()){
                    reverse.set(rand.nextDouble() < cons.getREVERSE_CHANCE() ? 1 : 0);
                    if(reverse.get()==1) {
                        for(int j =0; j<cons.getGAME_NUMBER()-1;j++) {
                            Trapezoid oldtrap=stack.get(stack.size() - 1-j);
                            if(oldtrap.getRadius()==stack.getLast().getRadius()) {
                                Trapezoid newtrap = new Trapezoid();
                                newtrap.update_trap_polygon(cons.getADDING_RADIUS(),oldtrap.getFirst_angle_in_degree()+180);
                                newtrap.polygon.setFill(cons.getTRAP_COLOR());
                                stack.add(newtrap);
                                gamepane.getChildren().add(stack.getLast().polygon);
                            }
                        }
                    }
                    else {
                        int i = rand.nextInt(3);
                        int j = rand.nextInt(cons.getGAME_NUMBER()-1);
                        //type1
                        if(i==0) {
                            Shaapes.Type1 pattern = new Shaapes.Type1();

                        }

                        else if(i==1) {
                            Shaapes.Type1 pattern = new Shaapes.Type1();
                        }
                        else if(i==2) {
                            Shaapes.Type1 pattern = new Shaapes.Type1();
                        }
                        pattern.update(cons.getADDING_RADIUS(), (double) (j * 360) /cons.getGAME_NUMBER());
                    }
                }


                //----------------------------------------------------------------flow
                for (Trapezoid trap : stack) {
                    trap.update_trap_polygon(Change.radius(trap.getRadius()), trap.getFirst_angle_in_degree() + cons.getDEGREE_DELTA());
                }
                //----------------------------------------------------------------flow

            }
        };
        animationTimer.start();
//--------------------------------------------------------------------------------while true

    }
}