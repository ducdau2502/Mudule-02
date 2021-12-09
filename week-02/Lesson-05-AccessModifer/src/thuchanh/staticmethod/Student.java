package thuchanh.staticmethod;

public class Student {
    private int rollno;
    private String name;
    private static String college = "ABCDEF";

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    static void change() {
        college = "Codegym";
    }

    void display() {
        System.out.printf("%-4d %-8s %-10s \n", rollno, name, college);
    }
}
