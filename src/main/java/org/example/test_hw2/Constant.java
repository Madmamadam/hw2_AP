package org.example.test_hw2;

public class Constant {
    private Double CENTRAL_X = 500.0;
    private Double CENTRAL_Y =300.0 ;
    private Double RATIO = 0.1;
    private Double ANGLE = 3.1415/3;
    private double CHANCE=0.60;
    // GAME_NUMBER is in {4,5,6}
    private int GAME_NUMBER = 6;

    private static Constant instance ;
    public static Constant getinstance() {
        if (instance == null) {
            instance = new Constant ();
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
}
