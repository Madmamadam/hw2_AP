package org.example.test_hw2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static java.lang.Math.*;
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
//        System.out.println("upadted player_right");
        double reference_angle=cons.getREFERENCE_ANGLE_IN_DEGREE()*(3.1415/180);

        double current_real_angle=Math.atan2(playercircle.getCenterY()-cons.getCENTRAL_Y(),playercircle.getCenterX()-cons.getCENTRAL_X());
        double next_real_angle=current_real_angle+cons.getCONTROL_DELTA_ANGLE();
        double effective_angle=abs(current_real_angle-reference_angle)%(2*3.1415/cons.getGAME_NUMBER());
        double angle_from_bisector=Math.abs(effective_angle-(2*3.1415/cons.getGAME_NUMBER()/2));
        double perpendicular = cons.getPLAYER_RADIUS()*cos(2*3.1415/cons.getGAME_NUMBER()/2);
        double radius= perpendicular/cos(angle_from_bisector);
        playercircle.setCenterX(cons.getCENTRAL_X()+radius*cos(next_real_angle));
        playercircle.setCenterY(cons.getCENTRAL_Y()+radius*sin(next_real_angle));
    }
    public static void update_player_left(){
        Constant cons = Constant.getinstance();
        double reference_angle=cons.getREFERENCE_ANGLE_IN_DEGREE()*(3.1415/180);
        double current_real_angle=Math.atan2(playercircle.getCenterY()-cons.getCENTRAL_Y(),playercircle.getCenterX()-cons.getCENTRAL_X());
        double next_real_angle=current_real_angle - cons.getCONTROL_DELTA_ANGLE();
        double effective_angle=abs(current_real_angle-reference_angle)%(2*3.1415/cons.getGAME_NUMBER());
        double angle_from_bisector=Math.abs(effective_angle-(2*3.1415/cons.getGAME_NUMBER()/2));
        double perpendicular = cons.getPLAYER_RADIUS()*cos(2*3.1415/cons.getGAME_NUMBER()/2);
        double radius= perpendicular /cos(angle_from_bisector);
        playercircle.setCenterX(cons.getCENTRAL_X()+radius*cos(next_real_angle));
        playercircle.setCenterY(cons.getCENTRAL_Y()+radius*sin(next_real_angle));
//        System.out.println(playercircle.getCenterX());
    }
    public static void update_player(){
        Constant cons = Constant.getinstance();
        double reference_angle=cons.getREFERENCE_ANGLE_IN_DEGREE()*(3.1415/180);
        double current_real_angle=Math.atan2(playercircle.getCenterY()-cons.getCENTRAL_Y(),playercircle.getCenterX()-cons.getCENTRAL_X());
        double radius = pow(pow(playercircle.getCenterX()-cons.getCENTRAL_X(),2)+pow(playercircle.getCenterY()-cons.getCENTRAL_Y(),2),0.5);
        double next_real_angle = current_real_angle + cons.getDEGREE_DELTA()*3.1415/180;


        playercircle.setCenterX(cons.getCENTRAL_X()+radius*cos(next_real_angle));
        playercircle.setCenterY(cons.getCENTRAL_Y()+radius*sin(next_real_angle));

    }
    public static void  update_Colors(){
        Constant cons = Constant.getinstance();

//        cons.setTRAP_COLOR(Color.hsb((cons.getTRAP_COLOR().getHue()+cons.getHUE_SPEED())%360,0.50,0.50));
        cons.setTHEME_COLOR1(Color.hsb((cons.getTHEME_COLOR1().getHue()+cons.getHUE_SPEED())%360,0.50,0.50));
        cons.setTHEME_COLOR2(Color.hsb((cons.getTHEME_COLOR2().getHue()+cons.getHUE_SPEED())%360,0.50,0.50));
        cons.setTHEME_COLOR3(Color.hsb((cons.getTHEME_COLOR3().getHue()+cons.getHUE_SPEED())%360,0.50,0.50));
        cons.setCENTER_POLY_COLOR(Color.hsb((cons.getCENTER_POLY_COLOR().getHue()+cons.getHUE_SPEED())%360,0.50,0.50));
        cons.setOUTLINE_COLOR(Color.hsb((cons.getOUTLINE_COLOR().getHue()+cons.getHUE_SPEED())%360,0.50,0.50));



    }

}
