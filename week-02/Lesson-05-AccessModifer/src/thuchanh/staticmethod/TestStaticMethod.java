package thuchanh.staticmethod;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student stu1 = new Student(1, "Hào");
        Student stu2 = new Student(2, "Dương");
        Student stu3 = new Student(3, "Long");

        stu1.display();
        stu2.display();
        stu3.display();
    }
}
