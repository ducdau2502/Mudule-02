package BaiTap;

import java.util.Scanner;

public class CountCharacters {
    public static void main(String[] args) {
        String str;
        String characters;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi bất kỳ: ");
        str = scanner.nextLine();
        System.out.println("Nhập vào một ký tự bất kỳ: ");
        characters = scanner.nextLine();

        int count = 0;


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == characters.charAt(0)) {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự " + characters +
                " trong chuỗi " + str + " = " + count);
    }
}
