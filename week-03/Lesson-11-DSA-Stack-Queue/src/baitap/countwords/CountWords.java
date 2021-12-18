package baitap.countwords;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWords {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a paragraph: ");
        String string = scanner.nextLine();
        int value;

        System.out.println();
        for (int i = 0; i < string.length(); i++) {
            String key = string.toUpperCase().charAt(i) + "";
            if (!treeMap.containsKey(key)) {
                treeMap.put(key, 1);
            } else {
                value = treeMap.get(key);
                treeMap.remove(key);
                treeMap.put(key, ++value);

            }
        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
