package thuchanh.simplelinkedlist;

import java.util.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);

        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,9);
        ll.printList();

        LinkedList<Integer> integers = new LinkedList<>();
        integers.clear();

        System.out.println(ll.get(3));
        System.out.println(ll.get(4));

    }
}
