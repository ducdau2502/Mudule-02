package btvn.main;

import btvn.manager.ManagerStudent;
import btvn.module.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student's quantity want to add: ");
        int size = scanner.nextInt();
        Student[] students = new Student[size];
        ManagerStudent managerStudent = new ManagerStudent(students);

        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1. Add student");
            System.out.println("2. Print all student");
            System.out.println("3. Student has highest point");
            System.out.println("4. Student has lowest point");
            System.out.println("5. Delete student");
            System.out.println("6. Find student by name");
            System.out.println("7. Find student by gender");
            System.out.println("8. Range student by point");
            System.out.println("9. Edit student by id");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    managerStudent.addStudent(scanner);
                    System.out.println(ManagerStudent.getIndex());
                    break;
                case 2:
                    managerStudent.displayAllStudent();
                    break;
                case 3:
                    managerStudent.findHighestPoint();
                    break;
                case 4:
                    managerStudent.findLowestPoint();
                    break;
                case 5:
                    managerStudent.deleteSutdent(scanner);
                    break;
                case 6:
                    managerStudent.findStudentByName(scanner);
                    break;
                case 7:
                    managerStudent.findStudentByGender(scanner);
                    break;
                case 8:
                    managerStudent.rangeStudentByAveragePoint();
                    break;
                case 9:
                    managerStudent.editStudentById(scanner);
                    break;
            }
        } while (choice != 0);
    }
}
