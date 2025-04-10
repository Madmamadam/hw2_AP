package org.example.test_hw2;

import javafx.scene.shape.Polygon;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Shapes {

    public Polygon new_trap_polygon(double radius , double first_angle_in_degree) {
        Constant cons = Constant.getinstance();
        Polygon trapezoid = new Polygon();
        double radius1=radius
        double radius2=radius*(1+cons.getRATIO());
        double first_angle = first_angle_in_degree*(3.1415/180.0);
        double second_angle=first_angle+cons.getANGLE();
        trapezoid.getPoints().addAll(radius1*sin(first_angle)+ cons.getCENTRAL_X() ,radius1*cos(first_angle)+ cons.getCENTRAL_Y());
        trapezoid.getPoints().addAll(radius2*sin(first_angle)+ cons.getCENTRAL_X() ,radius2*cos(first_angle)+ cons.getCENTRAL_Y());
        trapezoid.getPoints().addAll(radius1*sin(first_angle)+ cons.getCENTRAL_X() ,radius1*cos(first_angle)+ cons.getCENTRAL_Y());
        trapezoid.getPoints().addAll(radius2*sin(first_angle)+ cons.getCENTRAL_X() ,radius2*cos(first_angle)+ cons.getCENTRAL_Y());
        return trapezoid;
    }

}
