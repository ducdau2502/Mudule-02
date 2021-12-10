package baitap.circle;

public class Main {
    public static void main(String[] args) {
//        Circle
        Circle circle = new Circle();
        circle.setColor("blue");
        circle.setRadius(5.0);
        System.out.println(circle);

        circle = new Circle(10.0, "green");
        System.out.println(circle);

//        Cylinder
        Cylinder cylinder = new Cylinder();
        cylinder.setColor("red");
        cylinder.setRadius(10.0);
        cylinder.setHeight(20.0);
        System.out.println(cylinder);
        System.out.println(cylinder.getPerimeter());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getVolume());

        cylinder = new Cylinder(15.0, "cyan", 10.0);
        System.out.println(cylinder);
        System.out.println(cylinder.getPerimeter());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getVolume());

//        Upcasting
        Cylinder cylinder1 = new Cylinder();
        Circle circle1 = (Circle) cylinder1;

//        circle1.getVolume(); circle1 không thể gọi phương thức từ lớp con Cylinder
        circle1.setRadius(25);
        circle1.setColor("pink");
//        circle2.sesetHeight(); circle1 không thể gọi phương thức từ lớp con Cylinder

        System.out.println(circle1.toString());
//        circle1.toString() trỏ đến toString của lớp Cylinder vì toString của lớp Cylinder đã Override toString của lớp cha

//        Downcasting
        Circle circle2 = new Cylinder();
        Cylinder cylinder2 = (Cylinder) circle2;

        cylinder2.setColor("red");
        cylinder2.setRadius(10.0);
        cylinder2.setHeight(20.0);

        System.out.println(cylinder2);
        System.out.println(cylinder2.getVolume());

    }
}
