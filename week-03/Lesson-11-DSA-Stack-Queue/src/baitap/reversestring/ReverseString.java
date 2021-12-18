package baitap.reversestring;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> strings = new Stack<>();

        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        for (int i = 0; i < inputString.length(); i++) {
            strings.push(inputString.charAt(i) + "");
        }

        System.out.println("Reverse string: ");

        for (int i = 0; i < inputString.length(); i++) {
            System.out.print(strings.pop());
        }

        System.out.println();

        Integer[] integers = {1, 3, 5, 7, 9, 8, 6, 4, 2};
        Stack<Integer> integers1 = new Stack<>();

        for (int i = 0; i < integers.length; i++) {
            integers1.push(integers[i]);
        }

        System.out.println("Reverse integer array: ");
        int size = integers1.size();
        for (int i = 0; i < size; i++) {
            System.out.print(integers1.pop() + " ");
        }

    }
}
