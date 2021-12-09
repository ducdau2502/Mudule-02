package BaiTap;

import java.util.Scanner;

public class MinElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số lượng phần tử của mảng 1: ");
        int[] array = new int[scanner.nextInt()];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }

        int minElement = array[0];

        for (int j = 1; j < array.length; j++) {
            if (minElement > array[j]) {
                minElement = array[j];
            }
        }

        System.out.println("Phần tử nhở nhất là " + minElement);
    }
}
