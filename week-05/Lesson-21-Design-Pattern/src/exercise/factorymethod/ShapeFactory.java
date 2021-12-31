package exercise.factorymethod;

public class ShapeFactory {
    public Shape getShape(String str) {
        if ("tron".equals(str)) {
            return new Circle();
        } else if ("vuong".equals(str)) {
            return new Square();
        } else {
            return new Rectangle();
        }
    }
}
