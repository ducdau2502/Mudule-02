package baitap.checkpalindrome;

import thuchanh.queueusinglinkedlist.MyLinkedListQueue;

import java.util.Scanner;
import java.util.Stack;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a paragraph: ");
        String strings = scanner.nextLine();

        Stack<String> stack = new Stack<>();
        MyLinkedListQueue queue = new MyLinkedListQueue();

        for (int i = 0; i < strings.length(); i++) {
            stack.push(strings.charAt(i) + "");
            queue.enqueue(strings.charAt(i) + "");
        }
        boolean flag = true;
        for (int i = 0; i < strings.length(); i++) {
            if (!stack.pop().equals(queue.dequeue().key)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(strings + " is a Palindrome");
        } else {
            System.out.println(strings + " is not a Palindrome");
        }
    }
}
