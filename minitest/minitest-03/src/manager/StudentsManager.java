package manager;

import models.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsManager {
    ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);

    public StudentsManager() {
        this.students = new ArrayList<>();
    }

    public void displayAllStudent() {
        System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student addStudent() throws Exception {
            System.out.print("Enter full name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            System.out.print("Enter math point: ");
            double mathPoint = scanner.nextDouble();
            System.out.print("Enter physics point: ");
            double physicsPoint = scanner.nextDouble();
            System.out.print("Enter chemistry point: ");
            double chemistryPoint = scanner.nextDouble();
            scanner.nextLine();
            Student student = new Student(name, age, mathPoint, physicsPoint, chemistryPoint);
            students.add(student);
            System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
            return student;
    }

    public Student editStudentById(int id) throws Exception {
        Student student = null;
        for (Student stu : students) {
            if (stu.getId() == id) {
                student = stu;
            }
        }

        if (student != null) {
            int index = students.indexOf(student);
            System.out.print("Update full name: ");
            String updateName = scanner.nextLine();
            student.setName(updateName);
            System.out.print("Update age: ");
            int updateAge = scanner.nextInt();
            student.setAge(updateAge);
            System.out.print("Update math point: ");
            double updateMathPoint = scanner.nextDouble();
            student.setMathPoint(updateMathPoint);
            System.out.print("Update physics point: ");
            double updatePhysicsPoint = scanner.nextDouble();
            student.setPhysicsPoint(updatePhysicsPoint);
            System.out.print("Update chemistry point: ");
            double updateChemistryPoint = scanner.nextDouble();
            scanner.nextLine();
            student.setChemistryPoint(updateChemistryPoint);
            students.set(index, student);
        }
        System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
        return student;
    }

    public Student deleteStudentById(int id) {
        Student student = null;
        for (Student stu : students) {
            if (stu.getId() == id) {
                student = stu;
            }
        }
        students.remove(student);
        System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
        return student;
    }

    public void findStudentById(int id) {
        System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
            }
        }
    }

    public ArrayList<Student> rangeStudentByPoint() {
        students.sort((o1, o2) -> (int) (o1.averagePoint() - o2.averagePoint()));
        System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
        return students;
    }

    public void findMaxAveragePoint() {
        ArrayList<Student> students1 = new ArrayList<>();

        double max = students.get(0).averagePoint();

        for (Student student : students) {
            if (max < student.averagePoint()) {
                max = student.averagePoint();
            }
        }

        for (Student student : students) {
            if (max == student.averagePoint()) {
                students1.add(student);
            }
        }
        System.out.printf("%-5S%-12S%-5S%-10S%-10S%-10S%S\n", "id", "Full name", "age", "math", "physics", "chemistry", "average");
        for (Student student : students1) {
            System.out.println(student);
        }
    }
}
