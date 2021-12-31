package exercise.factorymethod;

public class DemoShapeFactory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("tron");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("vuong");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("abc");
        shape3.draw();
    }
}
