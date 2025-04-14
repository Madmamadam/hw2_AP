package org.example.test_hw2;

import javafx.scene.shape.Circle;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static org.example.test_hw2.HelloApplication.playercircle;

public class Change {
    public static double radius(double r){
        Constant cons = Constant.getinstance();
        if(cons.getCONSTANT_DECENT_MODE()){
            return r- cons.getDECENT_CONSTANT();
        }
        else {
            return r* cons.getDECENT_SCALE();
        }
    }
    public static void update_player_right(){
        Constant cons = Constant.getinstance();
        System.out.println("upadted player_right");
        double current_real_angle=Math.atan2(playercircle.getCenterY(),playercircle.getCenterX());
        double next_real_angle=current_real_angle+cons.getCONTROL_DELTA_ANGLE();
        double effective_angle=current_real_angle%(2*3.1415/cons.getGAME_NUMBER());
        double angle_from_bisector=Math.abs(effective_angle-(2*3.1415/cons.getGAME_NUMBER()/2));
        double perpendicular = cons.getPLAYER_RADIUS()*cos(2*3.1415/cons.getGAME_NUMBER()/2);
        double radius= perpendicular/cos(angle_from_bisector);
        playercircle.setCenterX(cons.getCENTRAL_X()+radius*cos(next_real_angle));
        playercircle.setCenterY(cons.getCENTRAL_Y()+radius*sin(current_real_angle));
    }
    public static void update_player_left(){
        Constant cons = Constant.getinstance();

        double current_real_angle=Math.atan2(playercircle.getCenterY(),playercircle.getCenterX());
        double next_real_angle=current_real_angle + cons.getCONTROL_DELTA_ANGLE();
        double effective_angle=current_real_angle%(2*3.1415/cons.getGAME_NUMBER());
        double angle_from_bisector=Math.abs(effective_angle-(2*3.1415/cons.getGAME_NUMBER()/2));
        double Perpendicular = cons.getPLAYER_RADIUS()*cos(2*3.1415/cons.getGAME_NUMBER()/2);
        double radius= Perpendicular /cos(angle_from_bisector);
        playercircle.setCenterX(cons.getCENTRAL_X()+radius*cos(next_real_angle));
        playercircle.setCenterY(cons.getCENTRAL_Y()+radius*sin(next_real_angle));
        System.out.println("upadted player_left");
        System.out.println(playercircle.getCenterX());
    }

}
