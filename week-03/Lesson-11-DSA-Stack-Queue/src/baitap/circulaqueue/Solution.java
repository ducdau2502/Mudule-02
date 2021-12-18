package baitap.circulaqueue;

public class Solution {
    public MyQueue myQueue;

    public Solution() {
        myQueue = new MyQueue();
    }

    public void enQueue(int value) {
        Node node = new Node();
        node.data = value;
        if (myQueue.front == null) {
            myQueue.front = node;
        } else {
            myQueue.rear.link = node;
        }

        myQueue.rear = node;
        myQueue.rear.link = myQueue.front;
    }

    public void deQueue() {
        if (myQueue.front != null) {
            if (myQueue.front == myQueue.rear) {
                myQueue.front = null;
                myQueue.rear = null;
            } else {
                myQueue.front = myQueue.front.link;
                myQueue.rear.link = myQueue.front;
            }
        }
    }

    public void displayQueue() {
        Node node = myQueue.front;
        do {
            System.out.println(node.data);
            node = node.link;
        } while (node.link != myQueue.front.link);
        System.out.println("--------------");
    }
}
