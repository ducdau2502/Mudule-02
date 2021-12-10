package thuchanh.shape;

public class ShapeTest {
    public static void main(String[] args) {

//      Shape test
        Shape shape = new Shape();
        System.out.println(shape);

        shape = new Shape("red", false);
        System.out.println(shape);

//      Circle test
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle("indigo", false, 3.5);
        System.out.println(circle);

//      Rectangle test
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8, "green", true);
        System.out.println(rectangle);

//        Square test
        Square square = new Square();
        square.setSide(5);
        System.out.println(square);

        square.setWidth(10);
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);


    }
}
