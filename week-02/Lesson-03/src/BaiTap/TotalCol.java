package BaiTap;

import java.util.Scanner;

public class TotalCol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array;
        int length;
        System.out.print("Nhập vào số lượng mảng 1 chiều: ");
        length = scanner.nextInt();

        int length1;
        System.out.print("Nhập vào số lượng phần tư trong mảng: ");
        length1 = scanner.nextInt();

        array = new int[length][length1];


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                System.out.print("Nhập vào phần tử dòng " + (i + 1) + " dòng " + (j + 1) + ": ");
                array[i][j] = scanner.nextInt();
            }
        }

        for (int j = 0; j < length; j++) {
            for (int k = 0; k < length1; k++) {
                System.out.print(array[j][k] + " ");
            }
            System.out.println(" ");
        }

        System.out.print("Nhập vào cột bạn muốn tính tổng: ");
        int col = scanner.nextInt();
        int sum = 0;
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                if (j == col - 1) {
                    sum += ints[j];
                }
            }
        }

        System.out.println("Tổng các phần tử trong cột là " + sum);
    }
}
