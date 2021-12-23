package main;

import manager.StudentsManager;
import models.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentsManager studentsManager = new StudentsManager();
        Scanner scanner = new Scanner(System.in);

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
            System.out.println("0. Exit");
            System.out.print("Enter you choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println(studentsManager.addStudent());
                    } catch (Exception e) {
                        System.out.println("Error format input");
                    }
                    break;
                case 2:
                    studentsManager.displayAllStudent();
                    break;
                case 3:
                    try {
                        System.out.print("Enter student's id you want to edit: ");
                        int editId = scanner.nextInt();
                        System.out.println(studentsManager.editStudentById(editId));
                    } catch (Exception e) {
                        System.out.println("Error format input");
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter student's id you want to remove: ");
                        int deleteId = scanner.nextInt();
                        System.out.println(studentsManager.deleteStudentById(deleteId));
                    } catch (InputMismatchException e) {
                        System.out.println("Error format input");
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Enter student's id you want to find: ");
                        int findId = scanner.nextInt();
                        studentsManager.findStudentById(findId);
                    } catch (InputMismatchException e) {
                        System.out.println("Error format input");
                    }
                    break;
                case 6:
                    ArrayList<Student> students1 = studentsManager.rangeStudentByPoint();
                    for (Student student : students1) {
                        System.out.println(student);
                    }
                    break;
                case 7:
                    studentsManager.findMaxAveragePoint();
                    break;
            }
        } while (choice != 0);
    }
}
