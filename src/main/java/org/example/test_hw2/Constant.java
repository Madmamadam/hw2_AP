package org.example.test_hw2;
import javafx.stage.Screen;

import javafx.scene.paint.Color;

public class Constant {
    private Double CENTRAL_X = Screen.getPrimary().getBounds().getWidth()/2;
    private Double CENTRAL_Y =Screen.getPrimary().getBounds().getHeight()/2 ;
    private Double RATIO = 0.15;
    private Double ANGLE = 3.1415/3;
    private double CHANCE=0.99;
    private double PAYE = 0.7;
    private double accPAYE =3;
    // GAME_NUMBER is in {4,5,6}
    private int GAME_NUMBER = 6;
    private double DECENT_CONSTANT =5*PAYE;
    private double DECENT_SCALE =0.98;
    private boolean CONSTANT_DECENT_MODE = true;
    private double DEGREE_DELTA = 0.6*PAYE;
    private boolean CLOCKWISE = true;
    private double NEED_ADD_RADIUS=1500;
    private double ADDING_RADIUS=NEED_ADD_RADIUS+200;
    private double REVERSE_CHANCE=0.1;
    private Color TRAP_COLOR = Color.GRAY;
    private Color THEME_COLOR1 = Color.BLACK;
    private Color THEME_COLOR2 = Color.PURPLE;
    private Color THEME_COLOR3 = Color.BLACK;
    private Color CENTER_POLY_COLOR = Color.BLACK;
    private double epsilon = NEED_ADD_RADIUS-ADDING_RADIUS/2;
    private double CONTROL_SPEED =10;
    private double REFERENCE_ANGLE_IN_DEGREE = 2;
    private double CENTRAL_RADIUS=40;
    private double PLAYER_RADIUS=CENTRAL_RADIUS*1.5;
    private double PLAYER_CIRCLE_RADIUS = 4;
    private double CONTROL_DELTA_ANGLE =8*3.1415/180*PAYE;
    private double ACC_DECENT_CONSTANT=0.0003*accPAYE;
//    private double ACC_DECENT_SCALE=0.01;
    private double ACC_DEGREE_DELTA=0.0002*accPAYE;
    private double ACC_CONTROL_DELTA_ANGLE =0.0008*3.1415/180*accPAYE;
    private long DEAD_SEEING_TIME=2;//millisecond
    private double HUE_SPEED =0.5;
    private Color OUTLINE_COLOR = Color.PURPLE;


    public double getACC_CONTROL_DELTA_ANGLE() {
        return ACC_CONTROL_DELTA_ANGLE;
    }

    public double getACC_DEGREE_DELTA() {
        return ACC_DEGREE_DELTA;
    }

    public double getACC_DECENT_CONSTANT() {
        return ACC_DECENT_CONSTANT;
    }
    private static Constant instance ;
    public static Constant getinstance() {
        if (instance == null) {
            instance = new Constant ();
            if(!instance.CLOCKWISE) {
                instance.DEGREE_DELTA = -instance.DEGREE_DELTA;
            }
        }
        return instance;
    }

    public Double getCENTRAL_X() {
        return CENTRAL_X;
    }

    public Double getCENTRAL_Y() {
        return CENTRAL_Y;
    }

    public Double getRATIO() {
        return RATIO;
    }
    public Double getANGLE() {return ANGLE;}
    public int getGAME_NUMBER() {
        return GAME_NUMBER;
    }
    public double getCHANCE() {
        return CHANCE;
    }
    public double getDECENT_CONSTANT() {
        return DECENT_CONSTANT;
    }
    public double getDECENT_SCALE() {
        return DECENT_SCALE;
    }
    public boolean getCONSTANT_DECENT_MODE() {
        return CONSTANT_DECENT_MODE;
    }
    public double getDEGREE_DELTA() {
        return DEGREE_DELTA;
    }
    public double getNEED_ADD_RADIUS() {
        return NEED_ADD_RADIUS;
    }
    public double getADDING_RADIUS() {
        return ADDING_RADIUS;
    }
    public double getREVERSE_CHANCE() {
        return REVERSE_CHANCE;
    }
    public Color getTRAP_COLOR() {
        return TRAP_COLOR;
    }
    public Color getTHEME_COLOR1() {return THEME_COLOR1;}
    public Color getTHEME_COLOR2() {return THEME_COLOR2;}
    public Color getTHEME_COLOR3() {return THEME_COLOR3;}
    public Color getCENTER_POLY_COLOR() {return CENTER_POLY_COLOR;}
    public double getEpsilon() {return epsilon;}
    public double getCONTROL_SPEED() {return CONTROL_SPEED;}
    public double getREFERENCE_ANGLE_IN_DEGREE(){return REFERENCE_ANGLE_IN_DEGREE;}
    public double getCENTRAL_RADIUS() {return CENTRAL_RADIUS;}
    public double getPLAYER_RADIUS() {return PLAYER_RADIUS;}
    public double getPLAYER_CIRCLE_RADIUS() {return PLAYER_CIRCLE_RADIUS;}
    public double getCONTROL_DELTA_ANGLE() {return CONTROL_DELTA_ANGLE;}
    public long getDEAD_SEEING_TIME() {return DEAD_SEEING_TIME;}
    public double getHUE_SPEED() {return HUE_SPEED;}
    public Color getOUTLINE_COLOR() {return OUTLINE_COLOR;}


    public void setREFERENCE_ANGLE_IN_DEGREE(double REFERENCE_ANGLE_IN_DEGREE) {
        this.REFERENCE_ANGLE_IN_DEGREE = REFERENCE_ANGLE_IN_DEGREE;
    }

    public void setDECENT_CONSTANT(double DECENT_CONSTANT) {
        this.DECENT_CONSTANT = DECENT_CONSTANT;
    }
    public void setCONTROL_DELTA_ANGLE(double CONTROL_DELTA_ANGLE) {
        this.CONTROL_DELTA_ANGLE = CONTROL_DELTA_ANGLE;
    }

    public void setDEGREE_DELTA(double DEGREE_DELTA) {
        this.DEGREE_DELTA = DEGREE_DELTA;
    }
    public void setTRAP_COLOR(Color TRAP_COLOR) {this.TRAP_COLOR = TRAP_COLOR;}
    public void setTHEME_COLOR1(Color THEME_COLOR1) {this.THEME_COLOR1 = THEME_COLOR1;}
    public void setTHEME_COLOR2(Color THEME_COLOR2) {this.THEME_COLOR2 = THEME_COLOR2;}
    public void setTHEME_COLOR3(Color THEME_COLOR3) {this.THEME_COLOR3 = THEME_COLOR3;}
    public void setCENTER_POLY_COLOR(Color CENTER_POLY_COLOR) {this.CENTER_POLY_COLOR = CENTER_POLY_COLOR;}
    public void setOUTLINE_COLOR(Color OUTLINE_COLOR) {this.OUTLINE_COLOR = OUTLINE_COLOR;}


}
