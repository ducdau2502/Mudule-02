package baitap.linkedlist;

public class MyLinkedList<E> {
    private Node head;
    public int numNodes = 0;

    public MyLinkedList() {
    }

    public void add(int index, E e) {
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = new Node(e);
        (current.next).next = temp;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        temp.next = head;
        head = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node current = head;
        for (int i = 1; i < numNodes - 1; i++) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = new Node(e);
        (current.next).next = temp;
        numNodes++;
    }

//    public E remove(int index) {
//        Node current = head;
//        for (int i = 1; i < index - 1; i++) {
//            current = current.next;
//        }
//        current = (current.next).next;
//        return current.next;
//        numNodes--;
//    }

}
