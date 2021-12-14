package thuchanh.comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(5);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(10, "indigo", false);

        System.out.println("Pre order");
        for (ComparableCircle compare: circles) {
            System.out.println(compare);
        }

        Arrays.sort(circles);

        System.out.println("After order");
        for (ComparableCircle compare: circles) {
            System.out.println(compare);
        }
    }
}
