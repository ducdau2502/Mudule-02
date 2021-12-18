package thuchanh.myqueue;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        System.out.println(myQueue.isQueueEmpty());

        myQueue.enQueue(10);
        myQueue.enQueue(20);
        myQueue.enQueue(30);
        myQueue.enQueue(40);

        System.out.println(myQueue.isQueueFull());

        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();

        System.out.println(myQueue.isQueueEmpty());


    }
}
