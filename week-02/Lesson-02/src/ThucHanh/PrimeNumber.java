package ThucHanh;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 2) {
            System.out.print(number + " is not a prime!!!");
        } else {
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print(number + " is a prime!!!");
            } else {
                System.out.print(number + " is not a prime!!!");
            }
        }

    }
}
