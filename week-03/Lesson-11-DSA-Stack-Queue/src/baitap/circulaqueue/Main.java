package baitap.circulaqueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.enQueue(10);
        solution.enQueue(20);
        solution.enQueue(30);
        solution.enQueue(40);
        solution.displayQueue();

        solution.deQueue();
        solution.deQueue();
        solution.deQueue();
        solution.displayQueue();

        solution.enQueue(50);
        solution.enQueue(60);
        solution.enQueue(70);
        solution.displayQueue();

    }
}
