package baitap.arraylist.manager;

import java.util.Scanner;

public interface Manager {
    void displayAllPerson();

    void addPerson(Scanner scanner, int choice, String name, int age);

    void findById(int id);

    void deleteById(int id);

    void editById(int id);

    void rangeByAvgPoint();

}
