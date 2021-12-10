package baitap.point;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(100, 100);
        System.out.println(point2D);
        point2D.setXY(50, 50);
        System.out.println(Arrays.toString(point2D.getXY()));

        Point3D point3D = new Point3D(10, 10, 10);
        System.out.println(point3D);
        point3D.setXYZ(20, 30 ,20);
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
