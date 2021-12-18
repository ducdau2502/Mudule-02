package baitap.converttobinary;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        Stack<Integer> longs = new Stack<>();
        int soDu;
        while (number > 0) {
            soDu = number % 2;
            longs.push(soDu);
            number = number / 2;
        }
        do {

            System.out.print(longs.pop());
        } while (!longs.isEmpty());
    }
}
