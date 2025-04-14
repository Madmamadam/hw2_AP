package org.example.test_hw2;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

import java.util.Random;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Shaapes {
    public static class Type1 {
        Constant cons = new Constant();
        private double radius;
        private double first_angle_in_degree;
        private int number_of_trapezoid = cons.getGAME_NUMBER() - 1;

        public double getRadius() {
            return radius;
        }

        public double getFirst_angle_in_degree() {
            return first_angle_in_degree;
        }


        public Trapezoid[] trapezoids = new Trapezoid[number_of_trapezoid];


        public void update(double radius, double first_angle_in_degree) {
            if (radius <= 0) radius = 0;
            this.radius = radius;
            this.first_angle_in_degree = first_angle_in_degree;
            for (int i = 0; i < number_of_trapezoid; i++) {
                this.trapezoids[i].update_trap_polygon(radius, first_angle_in_degree + 360 * i / cons.getGAME_NUMBER());
            }
        }

        //initialize
        public Type1() {
            for (int i = 0; i < number_of_trapezoid; i++) {
                this.trapezoids[i] = new Trapezoid();
                this.trapezoids[i].polygon = new Polygon();
            }
        }
    }
    public static class Type2 {
        Constant cons = new Constant();
        private double radius;
        private double first_angle_in_degree;
        private int number_of_trapezoid = cons.getGAME_NUMBER() / 2;
        public Trapezoid[] trapezoids = new Trapezoid[number_of_trapezoid];

        public double getRadius() {
            return radius;
        }

        public double getFirst_angle_in_degree() {
            return first_angle_in_degree;
        }

        public void update(double radius, double first_angle_in_degree) {
            if (radius <= 0) {
                radius = 0;
            }
            this.radius = radius;
            this.first_angle_in_degree = first_angle_in_degree;
            for (int i = 0; i < number_of_trapezoid; i++) {
                this.trapezoids[i].update_trap_polygon(radius, first_angle_in_degree + 360 * 2 * i / cons.getGAME_NUMBER());
            }
        }

        //initialize
        public Type2() {
            for (int i = 0; i < number_of_trapezoid; i++) {
                this.trapezoids[i] = new Trapezoid();
                this.trapezoids[i].polygon = new Polygon();
            }
        }
    }
    public static class Type3 {
        Constant cons = new Constant();
        private double radius;
        private double first_angle_in_degree;
        private int number_of_trapezoid = cons.getGAME_NUMBER() - 1;
        private int [] exit = new int[number_of_trapezoid];

        public double getRadius() {
            return radius;
        }

        public double getFirst_angle_in_degree() {
            return first_angle_in_degree;
        }


        public Trapezoid[] trapezoids = new Trapezoid[number_of_trapezoid];


        public void update(double radius, double first_angle_in_degree) {
            if (radius <= 0) radius = 0;
            this.radius = radius;
            this.first_angle_in_degree = first_angle_in_degree;
            for (int i = 0; i < number_of_trapezoid; i++) {
                if (exit[i] == 1) {
//                    System.out.println("i="+i);
                    this.trapezoids[i].update_trap_polygon(radius, first_angle_in_degree + (360 * i) / cons.getGAME_NUMBER());
                }
            }
        }

        //initialize
        public Type3() {
            Random rand = new Random();
            for (int i = 0; i < number_of_trapezoid; i++) {

                this.trapezoids[i] = new Trapezoid();
                this.trapezoids[i].polygon = new Polygon();
                this.exit[i] = rand.nextDouble() < cons.getCHANCE() ? 1 : 0;
//                System.out.println(i+":"+exit[i]);
            }
        }

    }
    public static class cenpolygan{
        private double radius;
        private double first_angle_in_degree_from_reference;

        public double getRadius() {return radius;}

        public double getFirst_angle_in_degree() {return first_angle_in_degree_from_reference;}

        public Polygon polygon = new Polygon();
        public void update_center_polygon(double radius, double first_angle_in_degree_from_reference) {
            Constant cons = Constant.getinstance();
//        System.out.println("cons.ref="+cons.getREFERENCE_ANGLE_IN_DEGREE());
            if (radius<0) radius = 0;
            this.radius = radius;
            this.first_angle_in_degree_from_reference = first_angle_in_degree_from_reference;
            polygon.getPoints().clear();
            double radius1=radius;
            double radius2=radius*(1+cons.getRATIO());
            double first_angle = (first_angle_in_degree_from_reference+cons.getREFERENCE_ANGLE_IN_DEGREE()) *(3.1415/180.0);
            for(int i=0;i<cons.getGAME_NUMBER();i++ ) {
                double i_th_angle = first_angle + i*2*3.1415/cons.getGAME_NUMBER();
                polygon.getPoints().addAll(radius1 * sin(i_th_angle) + cons.getCENTRAL_X(), radius1 * cos(i_th_angle) + cons.getCENTRAL_Y());
                polygon.getPoints().addAll(radius2 * sin(i_th_angle) + cons.getCENTRAL_X() ,radius2*cos(i_th_angle)+ cons.getCENTRAL_Y());

            }
        }
    }
    public static class player_mahlar {
        private double radius;
        private double first_angle_in_degree_from_reference;
        public double getRadius() {return radius;}
        public double getFirst_angle_in_degree_from_reference() {return first_angle_in_degree_from_reference;}
        public Circle circle = new Circle();
        public void update_circle(double radius, double first_angle_in_degree_from_reference) {

        }
    }

    public static class theme_triangle{
        Constant cons = Constant.getinstance();
        Polygon[] polygons = new Polygon[cons.getGAME_NUMBER()];
        public void update() {
            for (int i = 0; i < cons.getGAME_NUMBER(); i++) {
                double reference_degree=cons.getREFERENCE_ANGLE_IN_DEGREE()*3.1415/180;
                polygons[i].getPoints().addAll(cons.getCENTRAL_X()+cons.getADDING_RADIUS()*cos(i*2*3.14115/cons.getGAME_NUMBER()+reference_degree),cons.getCENTRAL_Y()+cons.getADDING_RADIUS()*sin(i*2*3.14115/cons.getGAME_NUMBER()+reference_degree));
                polygons[i].getPoints().addAll(cons.getCENTRAL_X()+cons.getADDING_RADIUS()*cos((i+1)*2*3.14115/cons.getGAME_NUMBER()+reference_degree),cons.getCENTRAL_X()+cons.getADDING_RADIUS()*sin(i*2*3.14115/cons.getGAME_NUMBER()+reference_degree));
                polygons[i].getPoints().addAll(cons.getCENTRAL_X(),cons.getCENTRAL_Y());
                if(i==cons.getGAME_NUMBER()-1 && i%2==0){
                    polygons[i].setFill(cons.getTHEME_COLOR3());
                }
                else if (i%2==0) {
                    polygons[i].setFill(cons.getTHEME_COLOR1());
                }
                else {
                    polygons[i].setFill(cons.getTHEME_COLOR2());
                }
            }
        }

    }
}
