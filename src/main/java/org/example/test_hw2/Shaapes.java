package org.example.test_hw2;

import javafx.scene.shape.Polygon;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Trapezoid {
    //main things
    double radius;
    double first_angle_in_degree;
    Polygon polygon;
    //another things


    public static Trapezoid update_trap_polygon(double radius , double first_angle_in_degree , Trapezoid trapezoid) {
        Constant cons = Constant.getinstance();
        Polygon polygon = new Polygon();
        double radius1=radius;
        double radius2=radius*(1+cons.getRATIO());
        double first_angle = first_angle_in_degree*(3.1415/180.0);
        double second_angle=first_angle+cons.getANGLE();
        //System.out.println(sin(3.1415/2));

        polygon.getPoints().addAll(radius1*sin(first_angle)  + cons.getCENTRAL_X() ,radius1*cos(first_angle)+ cons.getCENTRAL_Y());
        polygon.getPoints().addAll(radius2*sin(first_angle)  + cons.getCENTRAL_X() ,radius2*cos(first_angle)+ cons.getCENTRAL_Y());
        polygon.getPoints().addAll(radius2*sin(second_angle) + cons.getCENTRAL_X() ,radius2*cos(second_angle)+ cons.getCENTRAL_Y());
        polygon.getPoints().addAll(radius1*sin(second_angle) + cons.getCENTRAL_X() ,radius1*cos(second_angle)+ cons.getCENTRAL_Y());
        return trapezoid;
    }

}
