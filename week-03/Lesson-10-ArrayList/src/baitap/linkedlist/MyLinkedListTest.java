package baitap.linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.add(0,7);
        myList.add(1,10);
        myList.add(2,8);
        myList.add(3,9);
        myList.add(4,5);
        printData(myList);
    }
    private static void printData(MyLinkedList<Integer> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " " + myList.get(i));
        }
        System.out.println("------");
    }
}
