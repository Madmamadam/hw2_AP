package org.example.test_hw2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloApplication {
    static AtomicBoolean isPaused = new AtomicBoolean(false);
    static Timeline timeline = new Timeline();
    static Circle playercircle = new Circle();
    static LocalDateTime start = LocalDateTime.now();
    public static void staart(Stage stage) {
        Constant cons = Constant.getinstance();

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));

        Pane gamepane = new Pane();

        playercircle.setFill(Color.WHITE);
        playercircle.setRadius(cons.getPLAYER_CIRCLE_RADIUS());
        playercircle.setCenterX(cons.getCENTRAL_X()+cons.getPLAYER_RADIUS());
        playercircle.setCenterY(cons.getCENTRAL_Y());


        Text timeLabel = new Text("Time: 00:00");
        timeLabel.setX(100);
        timeLabel.setY(100);
        timeLabel.setFill(Color.WHITE);
        timeLabel.setFont(Font.font("Verdana", FontWeight.BOLD , 20));
        timeLabel.setSelectionFill(Color.PURPLE);

        Shaapes.theme_triangle theme_triangle = new Shaapes.theme_triangle();
        theme_triangle.update();
        for (int i = 0; i <cons.getGAME_NUMBER(); i++) {
            gamepane.getChildren().add(theme_triangle.polygons[i]);
        }




//        root= fxmlLoader.load();
//        Scene scene = new Scene(root);
        Scene gamescene = new Scene(gamepane);

        stage.setScene(gamescene);
        Shaapes.cenpolygan centerpoly = new Shaapes.cenpolygan();
        Shaapes.outer_center_poly outer_center_polygon = new Shaapes.outer_center_poly();
        outer_center_polygon.update(cons.getCENTRAL_RADIUS(),0);
        centerpoly.update_center_polygon(cons.getCENTRAL_RADIUS(),centerpoly.getFirst_angle_in_degree());
        centerpoly.polygon.setFill(cons.getCENTER_POLY_COLOR());

        Set<KeyCode> keysPressed = new HashSet<>();
        gamescene.setOnKeyPressed(event -> {
            keysPressed.add(event.getCode());
            if (event.getCode() == KeyCode.SPACE) {
                togglePause();
            }
            if (event.getCode() == KeyCode.ESCAPE){
                timeline.stop();
                stage.hide();
            }
        });
        gamescene.setOnKeyReleased(event -> {
            keysPressed.remove(event.getCode());
        });

        stage.setFullScreen(true);
//        stage.setMaximized(true);

        stage.show();
        // Force the stage to the front.
        stage.setAlwaysOnTop(true);
        stage.toFront();
        stage.requestFocus();
        gamepane.requestFocus();

        // Reset always-on-top after a short delay.
        Platform.runLater(() -> stage.setAlwaysOnTop(false));



//--------------------------------------------------------------------------------while
        ArrayList<Trapezoid> stack = new ArrayList<>();
        stack.add(new Trapezoid());
        AtomicInteger reverse = new AtomicInteger(0);
        Random rand = new Random();


        timeline = new Timeline(new KeyFrame(Duration.millis(17), event -> {
                //------------------------------------------------------------------------ADD
                if(stack.getLast().getRadius() <cons.getNEED_ADD_RADIUS()){
                    if(reverse.get()==1) {
                        int counter=0;
                        for(int j =0; -1<stack.size() -1 -j-counter && j<cons.getGAME_NUMBER()-1;j++) {
                            Trapezoid oldtrap=stack.get(stack.size() -1 -j-counter);
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
//                        System.out.println("khorde khorde");
                        timeline.stop();
                        stage.hide();

//                        FXMLLoader fxml = new FXMLLoader();
                        return;
//                        break;
                    }

//                    if(trap.getRadius()==0) {
//                        stack.remove(trap);
                }
                //----------------------------------------------------------------flow

                //----------------------------------------------------------------control
                if (keysPressed.contains(KeyCode.RIGHT)) {
                    Change.update_player_right();
                }
                if (keysPressed.contains(KeyCode.LEFT)) {
                    Change.update_player_left();
                }

                // Update the label with the current time
                timeLabel.setText("Time: " + formatDuration());

                centerpoly.update_center_polygon(cons.getCENTRAL_RADIUS(), centerpoly.getFirst_angle_in_degree());
                outer_center_polygon.update(outer_center_polygon.getRadius(), outer_center_polygon.getFirst_angle_in_degree());

                theme_triangle.update();
                cons.setREFERENCE_ANGLE_IN_DEGREE(cons.getREFERENCE_ANGLE_IN_DEGREE()+cons.getDEGREE_DELTA());
                centerpoly.polygon.toFront();
                timeLabel.toFront();

                for (int i = 0; i < cons.getGAME_NUMBER(); i++) {
                    outer_center_polygon.trapezoids[i].polygon.toFront();
                }
                playercircle.toFront();
                Change.update_player();
                cons.setDEGREE_DELTA(cons.getDEGREE_DELTA()+cons.getACC_DEGREE_DELTA());
                cons.setCONTROL_DELTA_ANGLE(cons.getCONTROL_DELTA_ANGLE()+cons.getACC_CONTROL_DELTA_ANGLE());
                cons.setDECENT_CONSTANT(cons.getDECENT_CONSTANT()+cons.getACC_DECENT_CONSTANT());
                Change.update_Colors();
                //----------------------------------------------------------------flow

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        gamepane.getChildren().add(centerpoly.polygon);
        gamepane.getChildren().add(playercircle);
        gamepane.getChildren().addAll(timeLabel);
        for (int i = 0; i < cons.getGAME_NUMBER(); i++) {
            gamepane.getChildren().addAll(outer_center_polygon.trapezoids[i].polygon);
        }



    }

    private static void togglePause() {
        isPaused.set(!isPaused.get());
        if (!isPaused.get()) {
            timeline.play();
        } else {
            timeline.pause();
        }
    }
    private static String formatDuration() {
        LocalDateTime now = LocalDateTime.now();
        double totalSeconds =24*60*60*now.getDayOfYear() + 60*60*now.getHour() + 60*now.getMinute() + now.getSecond()-24*60*60*start.getDayOfYear()-60*60*start.getHour() -60*start.getMinute() -start.getSecond();
        int minutes = (int) (totalSeconds / 60);
        int seconds = (int) (totalSeconds % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}