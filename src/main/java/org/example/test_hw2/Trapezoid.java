package org.example.test_hw2;

import javafx.scene.shape.Polygon;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Trapezoid {
    //main things
    private double radius;
    private double first_angle_in_degree;

    public double getRadius() {
        return radius;
    }
    public double getFirst_angle_in_degree() {
        return first_angle_in_degree;
    }


    Polygon polygon;
    // Constructor to initialize the polygon
    public Trapezoid() {
        polygon = new Polygon();
    }


    public void update_trap_polygon(double radius, double first_angle_in_degree) {
        Constant cons = Constant.getinstance();
        if (radius<0) radius = 0;
        this.radius = radius;
        this.first_angle_in_degree = first_angle_in_degree;
        polygon.getPoints().clear();
        double radius1=radius;
        double radius2=radius*(1+cons.getRATIO());
        double first_angle = first_angle_in_degree*(3.1415/180.0);
        double second_angle=first_angle+2*3.1415/cons.getGAME_NUMBER();
        //System.out.println(sin(3.1415/2));

        polygon.getPoints().addAll(radius1*sin(first_angle)  + cons.getCENTRAL_X() ,radius1*cos(first_angle)+ cons.getCENTRAL_Y());
        polygon.getPoints().addAll(radius2*sin(first_angle)  + cons.getCENTRAL_X() ,radius2*cos(first_angle)+ cons.getCENTRAL_Y());
        polygon.getPoints().addAll(radius2*sin(second_angle) + cons.getCENTRAL_X() ,radius2*cos(second_angle)+ cons.getCENTRAL_Y());
        polygon.getPoints().addAll(radius1*sin(second_angle) + cons.getCENTRAL_X() ,radius1*cos(second_angle)+ cons.getCENTRAL_Y());
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
