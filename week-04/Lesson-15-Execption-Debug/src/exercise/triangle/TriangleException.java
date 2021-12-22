package exercise.triangle;

import java.util.Scanner;

public class TriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        int x = scanner.nextInt();
        System.out.println("Hãy nhập y: ");
        int y = scanner.nextInt();
        System.out.println("Hãy nhập z: ");
        int z = scanner.nextInt();

        try {
            calculate(x, y, z);
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi rồi đmm " + e.getMessage());
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
