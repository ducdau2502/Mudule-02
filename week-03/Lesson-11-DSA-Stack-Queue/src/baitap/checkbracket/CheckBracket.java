package baitap.checkbracket;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        String string1 = "s * (s – a) * (s – b) * (s – c)";
        String string2 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String string3 = "s * (s – a) * (s – b * (s – c)";
        String string4 = "s * (s – a) * s – b) * (s – c)";
        String string5 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        checkBracket(string1);
        checkBracket(string2);
        checkBracket(string3);
        checkBracket(string4);
        checkBracket(string5);
    }

    public static void checkBracket(String str) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();

        for (int i = 0; i <str.length(); i++) {
            String key = str.charAt(i) + "";
            if (key.equals("(")) {
                stack.push(key);
            }
            if (key.equals(")")) {

                stack1.push(key);
            }
        }

        if (stack.size() == stack1.size()) {
            System.out.println("Well");
        } else {
            System.out.println("???");
        }
    }
}
