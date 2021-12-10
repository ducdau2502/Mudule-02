package baitap.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Triangle tri = new Triangle();
        System.out.println(tri);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào thông tin hình tam giác");
        System.out.print("Nhập vào độ dài cạnh thứ 1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Nhập vào độ dài cạnh thứ 2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Nhập vào độ dài cạnh thứ 3: ");
        double side3 = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhập vào màu của hình tam giác: ");
        String color = scanner.nextLine();

        Triangle triangle = new Triangle(color, true, side1, side2, side3);
        System.out.println(triangle);

    }
}
