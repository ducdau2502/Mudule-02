package baitap.moveablePoint;

public class Main {
    public static void main(String[] args) {
        Point point1 = new MoveablePoint();
        MoveablePoint point2 = (MoveablePoint) point1;
        point2.setX(50);
        point2.setY(50);
        point2.setxSpeed(5);
        point2.setySpeed(10);
        System.out.println(point2);

        point2.move();
        System.out.println(point2);

        point2.move();
        System.out.println(point2);

        point2.move();
        System.out.println(point2);

        point2.move();
        System.out.println(point2);

        MoveablePoint point = new MoveablePoint(100, 100, 2, 2);
        System.out.println(point);
        point.move();
        System.out.println(point);
    }
}
