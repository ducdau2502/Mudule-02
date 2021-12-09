package BaiTap.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];

        Student stu0 = new Student("Hào", 18, "Undefined", "Hà Nội", 8, 7, 6);
        Student stu1 = new Student("Dương", 18, "Lam", "Hà Lội", 7, 8, 9);
        Student stu2 = new Student("Long", 18, "Nam", "Hà Nội", 9, 8, 6);

        students[0] = stu0;
        students[1] = stu1;
        students[2] = stu2;

        for (Student k: students) {
            System.out.println(k);
        }
        for (Student k: students) {
            System.out.println(k.averageScores());
        }
    }
}
