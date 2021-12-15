package thuchanh.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(10);
        circles[1] = new Circle();
        circles[2] = new Circle(5, "indigo", false);

        System.out.println("Pre order");
        for (Circle c : circles) {
            System.out.println(c);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After order");
        for (Circle c : circles) {
            System.out.println(c);
        }
    }
}
