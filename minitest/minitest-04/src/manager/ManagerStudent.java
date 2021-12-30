package manager;

import module.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerStudent {
    public static final String PATH_NAME = "src/csvfile/students.csv";
    ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);

    public ManagerStudent() {
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayAllStudent() {
        if (students.isEmpty()) {
            System.out.println("Empty...!!!");
        } else {
            System.out.println("Display All ");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
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
        writeFile(students, PATH_NAME);
        System.out.println("Add student named: " + student.getName() + "successful...!!!");
        return student;
    }

    public Student updateStudentById(int id) {
        Student student = null;

        for (Student stu : students) {
            if (stu.getId() == id) {
                student = stu;
                break;
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
            student.setChemistryPoint(updateChemistryPoint);
            scanner.nextLine();

            students.set(index, student);
            writeFile(students, PATH_NAME);
            System.out.println("Update student successful");
        } else {
            System.out.println("Student not found");
        }
        return student;
    }

    public Student deleteStudentById(int id) {
        Student student = null;

        for (Student stu : students) {
            if (stu.getId() == id) {
                student = stu;
                break;
            }
        }

        if (student != null) {
            students.remove(student);
            writeFile(students, PATH_NAME);
            System.out.println("Delete successful");
        } else {
            System.out.println("Student not found");
        }
        return student;
    }

    public Student findStudentById(int id) {
        Student student = null;

        for (Student stu : students) {
            if (stu.getId() == id) {
                student = stu;
                break;
            }
        }

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
        return student;
    }

    public ArrayList<Student> RangeLowToHigh() {
        ArrayList<Student> students1 = new ArrayList<>();
        students1.addAll(students);

        students1.sort((o1, o2) -> {
            if (o1.averagePoint() > o2.averagePoint()) {
                return 2;
            } else if (o1.averagePoint() < o2.averagePoint()) {
                return -2;
            } else {
                return 0;
            }
        });
        return students1;
    }

    public ArrayList<Student> RangeHighToLow() {
        ArrayList<Student> students2 = new ArrayList<>();
        students2.addAll(students);

        students2.sort((o1, o2) -> {
            if (o1.averagePoint() < o2.averagePoint()) {
                return 1;
            } else if (o1.averagePoint() > o2.averagePoint()) {
                return -1;
            } else {
                return 0;
            }
        });
        return students2;
    }

    public ArrayList<Student> HighestPoint() {
        ArrayList<Student> students3 = new ArrayList<>();
        double max = students.get(0).averagePoint();

        for (Student student : students) {
            if (max < student.averagePoint()) {
                max = student.averagePoint();
            }
        }

        for (Student student : students) {
            if (max == student.averagePoint()) {
                students3.add(student);
            }
        }

        return students3;
    }

    public void writeFile(ArrayList<Student> students, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Student student : students) {
                bufferedWriter.append(String.valueOf(student.getId()));
                bufferedWriter.append(",");
                bufferedWriter.append(student.getName());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(student.getAge()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(student.getMathPoint()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(student.getPhysicsPoint()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(student.getChemistryPoint()));
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();
            System.out.println("Write file successfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> readFile(String path) {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(PATH_NAME);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                int id = Integer.parseInt(strings[0]);
                String name = strings[1];
                int age = Integer.parseInt(strings[2]);
                double mathPoint = Double.parseDouble(strings[3]);
                double physicsPoint = Double.parseDouble(strings[4]);
                double chemistryPoint = Double.parseDouble(strings[5]);
                students.add(new Student(id, name, age, mathPoint, physicsPoint, chemistryPoint));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return students;
    }
}
