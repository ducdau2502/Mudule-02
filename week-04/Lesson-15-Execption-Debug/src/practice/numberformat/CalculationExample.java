package practice.numberformat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        int x = 0;
        try {
            x = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" lỗi format");
        }

        System.out.println("Hãy nhập y: ");
        int y = 0;
        try {
            y = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" lỗi format");
        }
        CalculationExample calc = new CalculationExample();
        calc.calculate(x, y);

    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
        } catch (Exception e) {
            System.err.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}
