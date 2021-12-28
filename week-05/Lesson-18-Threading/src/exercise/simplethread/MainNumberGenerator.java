package exercise.simplethread;

public class MainNumberGenerator {
    public static void main(String[] args) {
        NumberGenerator n1 = new NumberGenerator("01");
        NumberGenerator n2 = new NumberGenerator("02");

        Thread thread1 = new Thread(n1);
        Thread thread2 = new Thread(n2);

        thread1.setPriority(1);
        thread1.setPriority(10);

        thread1.start();
        thread2.start();

    }
}
