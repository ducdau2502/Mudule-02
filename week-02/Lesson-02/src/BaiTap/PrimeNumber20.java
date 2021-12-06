package BaiTap;

import java.util.Scanner;

public class PrimeNumber20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 2;
        int count = 0;
        int countPrimes;
        System.out.println("Nhập số lượng số nguyên tố: ");
        countPrimes = scanner.nextInt();

        while (count < countPrimes) {
                boolean flag = true;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.print(number + ", ");
                    count++;
                }

                number++;
            }
        }
    }
