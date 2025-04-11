package org.example.test_hw2;

import javafx.scene.shape.Polygon;

import java.util.Random;

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
                System.out.println(exit[i]);
            }
        }

    }
}
