package BaiTap;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int addIndex;
        int addElement;
        System.out.println("Nhập vào số lượng phần tử của mảng: ");
        array = new int[scanner.nextInt()];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập vào phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }

        for (int k : array) {
            System.out.print(k + "\t");
        }

        System.out.println();
        System.out.println("Nhập vào phần tử muốn thêm: ");
        addElement = scanner.nextInt();
        do {
            System.out.println("Nhập vào vị trí muốn: ");
            addIndex = scanner.nextInt();
        } while (addIndex < 0 || addIndex > array.length);


        int[] result = new int[array.length + 1];
        for (int j = 0; j <= array.length; j++) {
            if (j < addIndex - 1) {
                result[j] = array[j];
            } else if (j == (addIndex - 1)) {
                result[j] = addElement;
            } else {
                result[j] = array[j - 1];
            }
        }

        for( int k :result) {
        System.out.print(k + "\t");
    }

}
}
