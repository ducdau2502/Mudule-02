package baitap.resizeableandcolorable.main;

import baitap.resizeableandcolorable.module.Circle;
import baitap.resizeableandcolorable.module.Rectangle;
import baitap.resizeableandcolorable.module.Shape;
import baitap.resizeableandcolorable.module.Square;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(10, "blue", true);
        System.out.println(square.getSide());
        System.out.println(square.getArea());

        double percent = Math.round(Math.random()*100);
        square.resize(percent);
        System.out.println(square.getSide());
        System.out.println(square.getArea());

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(5, 10);
        shapes[2] = new Square(10);

        for (Shape shape: shapes) {
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
        }
    }
}
