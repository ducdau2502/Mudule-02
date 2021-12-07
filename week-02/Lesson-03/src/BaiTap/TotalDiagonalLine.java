package BaiTap;

import java.util.Scanner;

public class TotalDiagonalLine {
    public static void main(String[] args) {
        int[][] arr;
        int lengthArray;
        int lengthArray1;
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập vào số lượng mảng 1 chiều: ");
        lengthArray = scan.nextInt();

        System.out.print("Nhập vào số lượng phần tư trong mảng: ");
        lengthArray1 = scan.nextInt();

        arr = new int[lengthArray][lengthArray1];


        int i = 0;
        while (i < lengthArray) {
            for (int j = 0; j < lengthArray1; j++) {
                System.out.print("Nhập vào phần tử dòng " + (i + 1) + " dòng " + (j + 1) + ": ");
                arr[i][j] = scan.nextInt();
            }
            i++;
        }

        for (int j = 0; j < lengthArray; j++) {
            for (int k = 0; k < lengthArray1; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println(" ");
        }

        int sum = 0;
        for (int j = 0; j < lengthArray; j++) {
            for (int k = 0; k < lengthArray1; k++) {
                if(j == k) {
                    sum += arr[j][k];
                }
            }

        }

        System.out.println("Tổng đường chéo chính là: " + sum);

    }
}
