package main;

import manager.ManagerStudent;
import module.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();

        int choice;
        do {
            System.out.println("------- Manu Bar ------");
            System.out.println("1. Add a student");
            System.out.println("2. Display all student");
            System.out.println("3. Edit student by id");
            System.out.println("4. Remove student by id");
            System.out.println("5. Find student by id");
            System.out.println("6. Range student by average point");
            System.out.println("7. Find student who have maximum average point");
            System.out.println("8. Write file");
            System.out.println("9. Read file");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println(managerStudent.addStudent());
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    managerStudent.displayAllStudent();
                    break;
                case 3:
                    try {
                        System.out.print("Enter student's id you want to update: ");
                        int updateId = scanner.nextInt();
                        System.out.println(managerStudent.updateStudentById(updateId));
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter student's id you want to delete: ");
                        int deleteId = scanner.nextInt();
                        System.out.println(managerStudent.deleteStudentById(deleteId));
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Enter student's id you want to find: ");
                        int findId = scanner.nextInt();
                        System.out.println(managerStudent.findStudentById(findId));
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    int choice1;
                    do {
                        System.out.println("1. Low to high");
                        System.out.println("2. High to low");
                        System.out.println("0. Back");
                        System.out.print("Enter your choice: ");
                        choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                ArrayList<Student> students1 = managerStudent.RangeLowToHigh();
                                for (Student student : students1) {
                                    System.out.println(student);
                                }
                                break;
                            case 2:
                                ArrayList<Student> students2 = managerStudent.RangeHighToLow();
                                for (Student student : students2) {
                                    System.out.println(student);
                                }
                                break;
                        }
                    } while (choice1 != 0);
                    break;
                case 7:
                    ArrayList<Student> students3 = managerStudent.HighestPoint();
                    for (Student student : students3) {
                        System.out.println(student);
                    }
                    break;
                case 8:
                    managerStudent.writeFile(managerStudent.getStudents(), ManagerStudent.PATH_NAME);
                    break;
                case 9:
                    ArrayList<Student> student4 = managerStudent.readFile(ManagerStudent.PATH_NAME);
                    student4.forEach(System.out::println);
                    break;
            }
        } while (choice != 0);
    }
}
