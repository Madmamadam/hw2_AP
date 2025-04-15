package org.example.test_hw2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication extends Application {
    public static Circle playercircle = new Circle();

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Constant cons = Constant.getinstance();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
//        Pane root = new Pane();
        Pane gamepane = new Pane();

        playercircle.setFill(Color.BLACK);
        playercircle.setRadius(cons.getPLAYER_CIRCLE_RADIUS());
        playercircle.setCenterX(cons.getCENTRAL_X()+cons.getPLAYER_RADIUS());
        playercircle.setCenterY(cons.getCENTRAL_Y());



        Shaapes.theme_triangle theme_triangle = new Shaapes.theme_triangle();
        theme_triangle.update();
        for (int i = 0; i <cons.getGAME_NUMBER(); i++) {
            gamepane.getChildren().add(theme_triangle.polygons[i]);
        }




//        root= fxmlLoader.load();
//        Scene scene = new Scene(root);
        Scene gamescene = new Scene(gamepane);
//        gamescene.setOnKeyPressed(event -> {
//            switch (event.getCode()) {
//                case RIGHT -> Change.update_player_right(); // Move Up
//                case LEFT  -> Change.update_player_left();
//            }
//        });
        stage.setScene(gamescene);
        Shaapes.cenpolygan centerpoly = new Shaapes.cenpolygan();
        centerpoly.update_center_polygon(cons.getCENTRAL_RADIUS(),centerpoly.getFirst_angle_in_degree());
        centerpoly.polygon.setFill(cons.getCENTER_POLY_COLOR());




        stage.setHeight(800);
        stage.setWidth(1200);
        stage.show();

        Set<KeyCode> keysPressed = new HashSet<>();
        gamescene.setOnKeyPressed(event -> {
            keysPressed.add(event.getCode());
        });

        gamescene.setOnKeyReleased(event -> {
            keysPressed.remove(event.getCode());
        });

//--------------------------------------------------------------------------------while
        ArrayList<Trapezoid> stack = new ArrayList<>();
        stack.add(new Trapezoid());
        AtomicInteger reverse = new AtomicInteger(0);
        Random rand = new Random();


        AnimationTimer animationTimer = new AnimationTimer() {
            @Override


            public void handle(long l) {
                //------------------------------------------------------------------------ADD
                if(stack.getLast().getRadius() <cons.getNEED_ADD_RADIUS()){
                    if(reverse.get()==1) {
                        int counter=0;
                        for(int j =0; j<cons.getGAME_NUMBER()-1;j++) {
                            Trapezoid oldtrap=stack.get(stack.size() - 1-j-counter);
                            if(oldtrap.getRadius()-stack.getLast().getRadius()<cons.getEpsilon() && oldtrap.getRadius()-stack.getLast().getRadius()>-cons.getEpsilon() ) {
                                Trapezoid newtrap = new Trapezoid();
                                newtrap.update_trap_polygon(cons.getADDING_RADIUS(),oldtrap.getFirst_angle_in_degree_from_reference()+180);
                                newtrap.polygon.setFill(cons.getTRAP_COLOR());
                                stack.add(newtrap);
                                gamepane.getChildren().add(stack.getLast().polygon);
                                counter+=1;
                            }
                        }
                    }
                    else {
                        int i = rand.nextInt(3);
                        int j = rand.nextInt(cons.getGAME_NUMBER()-1);
                        //type1
                        if(i==0) {
                            Shaapes.Type1 pattern = new Shaapes.Type1();
                            pattern.update(cons.getADDING_RADIUS(), (double) (j * 360) /cons.getGAME_NUMBER());
                            for(int k =0; k<pattern.trapezoids.length;k++) {
                                pattern.trapezoids[k].polygon.setFill(cons.getTRAP_COLOR());
                                stack.add(pattern.trapezoids[k]);
                                gamepane.getChildren().add(stack.getLast().polygon);
                            }

                        }

                        else if(i==1) {
                            Shaapes.Type2 pattern = new Shaapes.Type2();
                            pattern.update(cons.getADDING_RADIUS(), (double) (j * 360) /cons.getGAME_NUMBER());
                            for(int k =0; k<pattern.trapezoids.length;k++) {
                                pattern.trapezoids[k].polygon.setFill(cons.getTRAP_COLOR());
                                stack.add(pattern.trapezoids[k]);
                                gamepane.getChildren().add(stack.getLast().polygon);
                            }
                        }
                        else if(i==2) {
                            Shaapes.Type3 pattern = new Shaapes.Type3();
                            pattern.update(cons.getADDING_RADIUS(), (double) (j * 360) /cons.getGAME_NUMBER());
                            for(int k =0; k<pattern.trapezoids.length;k++) {
                                pattern.trapezoids[k].polygon.setFill(cons.getTRAP_COLOR());
                                stack.add(pattern.trapezoids[k]);
                                gamepane.getChildren().add(stack.getLast().polygon);
                            }
                        }
                    }
                    //---------------------------------------------------------------------------ADD

                    reverse.set(rand.nextDouble() < cons.getREVERSE_CHANCE() ? 1 : 0);
                }



                //----------------------------------------------------------------flow
                for (Trapezoid trap : stack) {
                    trap.update_trap_polygon(Change.radius(trap.getRadius()), trap.getFirst_angle_in_degree_from_reference());
                    Shape intersection = Shape.intersect(trap.polygon , playercircle);
                    boolean isColliding = intersection.getBoundsInLocal().getWidth() > 0 &&
                            intersection.getBoundsInLocal().getHeight() > 0;
                    if(isColliding) {
                        System.out.println("khorde khorde");
                        this.stop();
                    }

//                    if(trap.getRadius()==0) {
//                        stack.remove(trap);
//                    }
                    //------------------------------------------------------------obstacle detection
                    //if(trap.getRadius()==playercircle
                    //------------------------------------------------------------obstacle detection
                }
                //----------------------------------------------------------------flow

                //----------------------------------------------------------------control
                centerpoly.update_center_polygon(cons.getCENTRAL_RADIUS(), centerpoly.getFirst_angle_in_degree());
                theme_triangle.update();
                cons.setREFERENCE_ANGLE_IN_DEGREE(cons.getREFERENCE_ANGLE_IN_DEGREE()+cons.getDEGREE_DELTA());
                centerpoly.polygon.toFront();
                playercircle.toFront();
                Change.update_player();
//                gamescene.setOnKeyPressed(event -> {
//                    switch (event.getCode()) {
//                        case RIGHT -> Change.update_player_right(); // Move Up
//                        case LEFT  -> Change.update_player_left();
//                    }
//                });
                if (keysPressed.contains(KeyCode.RIGHT)) {
                    Change.update_player_right();
                }
                if (keysPressed.contains(KeyCode.LEFT)) {
                    Change.update_player_left();
                }
                //----------------------------------------------------------------flow
            }
        };
        animationTimer.start();
        //--------------------------------------------------------------------------------while true
        gamepane.getChildren().add(centerpoly.polygon);
        gamepane.getChildren().add(playercircle);
    }
}