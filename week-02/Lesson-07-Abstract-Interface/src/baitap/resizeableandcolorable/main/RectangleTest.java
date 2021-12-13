package baitap.resizeableandcolorable.main;

import baitap.resizeableandcolorable.module.Rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 20, "orange", true);
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getArea());
        double percent = Math.round(Math.random()*100);
        rectangle.resize(percent);
        System.out.println(rectangle.getWidth());
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getArea());

    }
}
