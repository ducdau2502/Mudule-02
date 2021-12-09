package BaiTap;

import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr;
        int arrLength;
        int arrlength1;
        System.out.print("Nhập vào số lượng mảng 1 chiều: ");
        arrLength = scanner.nextInt();
        System.out.print("Nhập vào số lượng phần tư trong mảng: ");
        arrlength1 = scanner.nextInt();
        arr = new int[arrLength][arrlength1];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Nhập vào phần tử dòng " + (i + 1) + " cột " + (j + 1) + ": ");
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println(" ");
        }

        int maxElement = arr[0][0];
        int col = 0;
        int row = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (maxElement < arr[i][j]) {
                    maxElement = arr[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        System.out.println("Phần tử lớn nhất là " + maxElement + " nằm ở dòng " + row + " cột " + col);
    }
}
