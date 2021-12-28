package exercise.displaynumber;

public class MainNumber {
    public static void main(String[] args) throws InterruptedException {
        OddNumber oddNumber = new OddNumber("odd number");
        EvenNumber evenNumber = new EvenNumber("even number");


        Thread t1 = new Thread(oddNumber);
        Thread t2 = new Thread(evenNumber);

        t1.start();
        t1.join();
        t2.start();
        System.out.println("----");

    }
}
