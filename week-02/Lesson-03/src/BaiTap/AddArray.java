package BaiTap;

import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1;
        int[] array2;
        System.out.print("Nhập vào số lượng phần tử của mảng 1: ");
        array1 = new int[scanner.nextInt()];
        int i = 0;
        while (i < array1.length) {
            System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
            i++;
        }

        System.out.print("Nhập vào số lượng phần tử của mảng 2: ");
        array2 = new int[scanner.nextInt()];
        int j = 0;
        while (j < array2.length) {
            System.out.print("Nhập vào phần tử thứ " + (j + 1) + ": ");
            array2[j] = scanner.nextInt();
            j++;
        }

        int[] array3 = new int[(array1.length + array2.length)];

        for (int k = 0; k < array1.length; k++) {
            array3[k] = array1[k];
        }

        for (int k = 0; k < array2.length; k++) {
            array3[array1.length + k] = array2[k];
        }

        for (int k : array3) {
            System.out.print(k + "\t");
        }
    }
}
