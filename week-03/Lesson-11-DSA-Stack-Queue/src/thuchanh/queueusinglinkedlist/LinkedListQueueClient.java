package thuchanh.queueusinglinkedlist;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue("a");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue().key);
        queue.enqueue("b");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
//        first in - first out
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}
