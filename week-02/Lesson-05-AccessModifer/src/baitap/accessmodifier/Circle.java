package baitap.accessmodifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    protected String getColor() {
        return this.color;
    }

//    Nếu modifier là private sẽ có lỗi
//    java: getColor() has private access in baitap.accessmodifier.Circle
}
