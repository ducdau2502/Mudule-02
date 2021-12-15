package btvn.bai1.manager;

import btvn.bai1.module.Student;

public class Comparable extends Student implements java.lang.Comparable<Student> {
    public Comparable() {
    }

    public Comparable(String name, int age, String gender, String address, double averagePoint, int id) {
        super(name, age, gender, address, averagePoint, id);
    }

    @Override
    public int compareTo(Student o) {
        if (o != null) {
            System.out.println(o);
            if (getAveragePoint() > o.getAveragePoint()) {
                return 1;
            } else if (getAveragePoint() < o.getAveragePoint()) {
                return -1;
            } else return 0;
        }
        else return 0;
    }
}
