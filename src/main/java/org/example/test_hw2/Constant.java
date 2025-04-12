package org.example.test_hw2;

import javafx.scene.paint.Color;

public class Constant {
    private Double CENTRAL_X = 500.0;
    private Double CENTRAL_Y =300.0 ;
    private Double RATIO = 0.1;
    private Double ANGLE = 3.1415/3;
    private double CHANCE=0.60;
    // GAME_NUMBER is in {4,5,6}
    private int GAME_NUMBER = 6;
    private double DECENT_CONSTANT =1;
    private double DECENT_SCALE =0.98;
    private boolean CONSTANT_DECENT_MODE = true;
    private double DEGREE_DELTA = 1;
    private boolean CLOCKWISE = true;
    private double NEED_ADD_RADIUS=900;
    private double ADDING_RADIUS=NEED_ADD_RADIUS+200;
    private double REVERSE_CHANCE=0.3;
    private Color TRAP_COLOR = Color.BLACK;
    private Color THEME_COLOR = Color.GREENYELLOW;


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
    public Double getANGLE() {
        return ANGLE;
    }
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
    public Color getTHEME_COLOR() {
        return THEME_COLOR;
    }
}
