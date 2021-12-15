package baitap.resizeableandcolorable.main;

import baitap.resizeableandcolorable.module.Circle;

public class CircleTest {
    public static void main(String[] args) {

        Circle circle = new Circle(10, "indigo", false);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        double percent = Math.round(Math.random()*100);
        circle.resize(percent);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());


    }
}