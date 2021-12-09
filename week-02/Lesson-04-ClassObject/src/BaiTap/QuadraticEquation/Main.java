package BaiTap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số a ");
        double number1 = scanner.nextDouble();
        System.out.print("Nhập vào số b ");
        double number2 = scanner.nextDouble();
        System.out.print("Nhập vào số c ");
        double number3 = scanner.nextDouble();

        QuadraticEquation quad = new QuadraticEquation(number1, number2, number3);

        displayResults(quad);
    }

    public static void displayResults(QuadraticEquation quad) {
        if (quad.getDiscriminant() > 0) {
            System.out.println("Phương trình có hai nghiệm: x1 = " + quad.getRoot1() + " và x2 = " + quad.getRoot2());
        } else if (quad.getDiscriminant() == 0) {
            System.out.println("Phương trình có một nghiệm: x = " + quad.getRoot1());
        } else {
            System.out.println("Phường trình vô nghiệm");
        }
    }
}
