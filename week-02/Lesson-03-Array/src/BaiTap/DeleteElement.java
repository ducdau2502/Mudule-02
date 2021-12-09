package BaiTap;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int size;
        int[] array;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử trong mảng: ");
        size = scanner.nextInt();
        array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        for (int k : array) {
            System.out.print(k + "\t");
        }
        System.out.println();
        System.out.println("Nhập vào phần tử muốn xoá: ");
        int deleteElement = scanner.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == deleteElement) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }

        for (int k : array) {
            System.out.print(k + "\t");
        }
    }
}
