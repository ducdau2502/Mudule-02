package thuchanh.myqueue;

public class MyQueue {
    private final int capacity;
    private final int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int currentSize) {
        this.capacity = currentSize;
        queueArr = new int[capacity];
    }

    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    public void enQueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue!");
        }
    }

    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Pop operation done! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
