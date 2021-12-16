package module;

public class Comparator extends Student implements java.util.Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAveragePoint() > o2.getAveragePoint()) {
            return 1;
        } else if (o1.getAveragePoint() > o2.getAveragePoint()) {
            return -1;
        } else {
            return 0;
        }
    }
}
