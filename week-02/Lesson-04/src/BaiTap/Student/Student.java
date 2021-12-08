package BaiTap.Student;

public class Student {
    String name;
    int age;
    String gender;
    String address;
    double mathScores;
    double literatureScores;
    double englishScores;

    public Student() {
    }

    public Student(String name, int age, String gender, String address, double mathScores, double literatureScores, double englishScores) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mathScores = mathScores;
        this.literatureScores = literatureScores;
        this.englishScores = englishScores;
    }

    public double averageScores() {
        return ((mathScores + literatureScores + englishScores) / 3);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mathScores=" + mathScores +
                ", literatureScores=" + literatureScores +
                ", englishScores=" + englishScores +
                '}';
    }
}
