package exercise.triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Hãy nhập x: ");
            int x = scanner.nextInt();
            System.out.print("Hãy nhập y: ");
            int y = scanner.nextInt();
            System.out.print("Hãy nhập z: ");
            int z = scanner.nextInt();
            calculate(x, y, z);
        } catch (InputMismatchException e) {
            System.out.println("lỗi định dạng....!!!!!!!!!!");
        } catch (IllegalTriangleException e) {
            System.out.println("đây không phải ba cạnh của tam giác.....!!!!!");
        }
    }

    private static void calculate(int x, int y, int z) throws IllegalTriangleException {
           if (x > 0 && y > 0 && z > 0 && x + y > z && y + z > x && x + z > y) {
                   System.out.println("Đây là 3 cạnh của tam giác");
               } else {
               throw new IllegalTriangleException();
           }
    }

    private static class IllegalTriangleException extends Exception {
    }

}
