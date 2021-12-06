package BaiTap;

import java.util.Scanner;

public class DrawShape2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int choice2 = 0;
        while (choice != 3) {
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the rectangle");
            System.out.println("3. Exit");
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
                    while (choice2 != 5) {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("1. Draw the rectangle 1");
                    System.out.println("2. Draw the rectangle 2");
                    System.out.println("3. Draw the rectangle 3");
                    System.out.println("4. Draw the rectangle 4");
                    System.out.println("5. Exit!!");
                    System.out.println("Enter your choice:");
                    choice2 = scanner2.nextInt();
                    Rectangle(choice2);
                }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("No choice!!!");
            }

        }
    }

    public static Integer Rectangle(int choiceNumber) {

            switch (choiceNumber) {
                case 1:
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
                case 2:
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
                case 3:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 4 - i; j > 0; j--) {
                            System.out.print("  ");
                        }
                        for (int j = 0; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println(" ");
                    }
                    break;
                case 4:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("  ");
                        }
                        for (int j = 5 - i; j > 0; j--) {
                            System.out.print("* ");
                        }
                        System.out.println(" ");
                    }
                    break;

                case 5:
                    break;
            }
        return choiceNumber;
    }

}