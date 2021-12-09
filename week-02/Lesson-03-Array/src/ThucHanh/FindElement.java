package ThucHanh;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name’s student: ");
        String inputName = scanner.nextLine();

        boolean flag = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(inputName)) {
                System.out.println("Position of the students in the list " + inputName + " is: " + i);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Not found" + inputName + " in the list.");
        }
    }
}
