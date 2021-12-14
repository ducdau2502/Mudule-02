package btvn.bai1.manager;

import btvn.bai1.module.Student;

public class Comparator extends Student implements java.util.Comparator<Student> {
    public Comparator() {
    }

    public Comparator(String name, int age, String gender, String address, double averagePoint, int id) {
        super(name, age, gender, address, averagePoint, id);
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 != null && o2 != null) {
            if (o1.getAveragePoint() > o2.getAveragePoint()) {
                return 1;
            } else if (o1.getAveragePoint() < o2.getAveragePoint()) {
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
