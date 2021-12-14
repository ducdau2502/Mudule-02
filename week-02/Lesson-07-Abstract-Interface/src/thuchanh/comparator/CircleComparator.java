package thuchanh.comparator;

import java.util.Comparator;

public class CircleComparator extends Circle implements Comparator<Circle> {

    public CircleComparator() {
    }

    public CircleComparator(double radius) {
        super(radius);
    }

    public CircleComparator(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() > o2.getRadius()) {
            return 1;
        } else if (o1.getRadius() < o2.getRadius()) {
            return -1;
        } else {
            return 1;
        }
    }
}