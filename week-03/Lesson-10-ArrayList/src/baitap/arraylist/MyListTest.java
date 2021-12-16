package baitap.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(0, 9);
        myList.add(1, 1);
        myList.add(2, 5);
        myList.add(3, 2);
        myList.add(4, 8);
        myList.add(5, 6);
        myList.add(6, 7);
        printData(myList);

        myList.remove(2);
        printData(myList);

//        Integer[] myList1 = myList.clone();
//        for (Integer i : myList1) {
//            System.out.println(i);
//        }

        System.out.println(myList.contains(5));
        System.out.println(myList.contains(6));
        System.out.println("------");
        System.out.println(myList.indexOf(5));
        System.out.println(myList.indexOf(2));
        System.out.println("------");
        System.out.println(myList.add(9));
        System.out.println("------");
        printData(myList);

        myList.clear();
        printData(myList);

        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(4);
    }

    private static void printData(MyList<Integer> myList) {
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(i + " " + myList.get(i));
        }
        System.out.println("------");
    }
}
