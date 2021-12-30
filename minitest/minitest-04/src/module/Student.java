package module;

public class Student extends Person {
    private double mathPoint;
    private double physicsPoint;
    private double chemistryPoint;

    public Student() {
    }

    public Student(String name, int age, double mathPoint, double physicsPoint, double chemistryPoint) {
        super(name, age);
        this.mathPoint = mathPoint;
        this.physicsPoint = physicsPoint;
        this.chemistryPoint = chemistryPoint;
    }

    public Student(int id, String name, int age, double mathPoint, double physicsPoint, double chemistryPoint) {
        super(id, name, age);
        this.mathPoint = mathPoint;
        this.physicsPoint = physicsPoint;
        this.chemistryPoint = chemistryPoint;
    }

    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getPhysicsPoint() {
        return physicsPoint;
    }

    public void setPhysicsPoint(double physicsPoint) {
        this.physicsPoint = physicsPoint;
    }

    public double getChemistryPoint() {
        return chemistryPoint;
    }

    public void setChemistryPoint(double chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public double averagePoint() {
        return ((getMathPoint() + getPhysicsPoint() + getChemistryPoint()) / 3);
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + super.getId() +
                ", name=" + super.getName() +
                ", age=" + super.getAge() +
                ", math point=" + getMathPoint() +
                ", physics point=" + getPhysicsPoint() +
                ", chemistry point=" + getChemistryPoint() +
                ", average point=" + averagePoint() +
                '}';
    }
}
