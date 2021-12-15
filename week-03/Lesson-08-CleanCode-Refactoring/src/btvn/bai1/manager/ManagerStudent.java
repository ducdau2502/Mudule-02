package btvn.bai1.manager;

import btvn.bai1.module.Student;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerStudent {
    public Student[] students;
    public static int index = 0;

    public ManagerStudent() {
    }

    public ManagerStudent(Student[] students) {
        this.students = students;
    }

    public void addStudent(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter average point: ");
        double averagePoint = scanner.nextDouble();

        students[index] = new Student(name, age, gender, address, averagePoint);
        index++;
    }

    public void displayAllStudent() {
        for (Student student : students) {
            boolean compareByNull = student != null;
            if (compareByNull) {
                System.out.println(student);
            }
        }
    }

    public void findHighestPoint() {
        double maxPoint = students[0].getAveragePoint();
        for (Student student : students) {
            if (student != null && maxPoint < student.getAveragePoint()) {
                maxPoint = student.getAveragePoint();
            }
        }
        for (Student student : students) {
            if (student != null && maxPoint == student.getAveragePoint()) {
                System.out.println(student);
            }
        }
    }

    public void findLowestPoint() {
        double minPoint = students[0].getAveragePoint();
        for (Student student : students) {
            if (student != null && minPoint > student.getAveragePoint()) {
                minPoint = student.getAveragePoint();
            }
        }
        for (Student student : students) {
            if (student != null && minPoint == student.getAveragePoint()) {
                System.out.println(student);
            }
        }
    }

    public void deleteSutdent(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter student's name want to delete: ");
        String deleteName = scanner.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && deleteName.equals(students[i].getName())) {
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[students.length - 1] = null;
            }
        }
        index--;
    }

    public void findStudentByName(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter student's name want to find: ");
        String findName = scanner.nextLine();
        for (Student student : students) {
            if (student != null && student.getName().equals(findName)) {
                System.out.println(student);
            }
        }
    }

    public void findStudentByGender(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter student's gender want to find: ");
        String findGender = scanner.nextLine();
        for (Student student : students) {
            if (student != null && student.getGender().equals(findGender)) {
                System.out.println(student);
            }
        }
    }

    public void rangeStudentByAveragePoint() {
        Comparator comparator = new Comparator();
        Arrays.sort(students, new Comparator());

        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
//        Arrays.sort(students);
//        for (Student student : students) {
//            if (student != null) {
//                System.out.println(student);
//            }
//        }
    }

    public void editStudentById(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter student's id want to edit: ");
        int editId = scanner.nextInt();
        for (Student student : students) {
            if (student != null && editId == student.getId()) {
                scanner.nextLine();
                System.out.print("Enter full name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Enter gender: ");
                student.setGender(scanner.nextLine());
                System.out.print("Enter address: ");
                student.setAddress(scanner.nextLine());
                System.out.print("Enter average point: ");
                student.setAveragePoint(scanner.nextDouble());
            }
        }
    }
}
