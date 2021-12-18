package baitap.linkedlist;

public class MyLinkedList<E> {
    private Node head;
    public int numNodes = 0;

    public MyLinkedList() {
    }

    public void add(int index, E e) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(e);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node temp = new Node(e);
        temp.next = head;
        head = temp;
        numNodes++;
    }

    public void addLast(E e) {
        if (head == null)
            addFirst(e);
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(e);
        }
        numNodes++;
    }

    public void remove(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp.next = temp.next.next;
        }

        numNodes--;
    }

    public boolean remove(E e) {
        Node temp = head;
        for (int i = 0; i < indexOf(e) && temp.next != null; i++) {
            temp.next = temp.next.next;
        }
        numNodes--;
        return true;
    }

    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public boolean contains(E e) {
        Node temp = head;
        for (int i = 0; i <= numNodes; i++) {
            if ((temp.data).equals(e)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        Node temp = head;
        int index = 0;
        for (int i = 0; i <= numNodes; i++) {
            if ((temp.data).equals(e)) {
                index = i;
                break;
            } else {
                temp = temp.next;
            }
        }
        return index;
    }

    public boolean add(E e) {
        Node current = head;
        for (int i = 1; i < indexOf(e); i++) {
            current = current.next;
        }
        Node temp = current.next;
        current.next = new Node(e);
        (current.next).next = temp;
        numNodes++;
        return true;
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        return (E) temp.data;
    }

    public E getFisrt() {
        return get(0);
    }

    public E getLast() {
        return get(numNodes);
    }

    public void clear() {
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            current = null;
            current = current.next;
        }
        head = null;
        numNodes = 0;
    }

}
