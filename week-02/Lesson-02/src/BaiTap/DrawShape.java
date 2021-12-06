package BaiTap;

import java.util.Scanner;

public class DrawShape {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the rectangle 01");
            System.out.println("3. Draw the rectangle 02");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("* ");
                        }
                        for (int j = 5 - i; j > 0; j--) {
                            System.out.print("  ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 5 - i; j > 0; j--) {
                            System.out.print("* ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("  ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!!!");
            }

        }
    }
}
