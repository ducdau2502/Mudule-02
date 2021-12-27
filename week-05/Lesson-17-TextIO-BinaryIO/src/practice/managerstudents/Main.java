package practice.managerstudents;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException ios) {
            ios.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
            try {
                FileInputStream is = new FileInputStream(path);
                ObjectInputStream ois = new java.io.ObjectInputStream(is);
                students = (List<Student>) ois.readObject();
                ois.close();
                is.close();
            }catch (IOException | ClassNotFoundException ios) {
                ios.printStackTrace();
            }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path name: ");
        String pathName = scanner.nextLine();

        writeToFile(pathName, students);
        List<Student> studentDataFromFile = readDataFromFile("src/practice/managerstudents/student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
