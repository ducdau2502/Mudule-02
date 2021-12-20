package baitap.arraylist.main;

import baitap.arraylist.manager.ManagerPerson;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerPerson maragerPerson = new ManagerPerson();
        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1. Display all person");
            System.out.println("2. Add person");
            System.out.println("3. Find person by Id");
            System.out.println("4. Delete person by Id");
            System.out.println("5. Edit person by Id");
            System.out.println("6. Range student by average point");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    maragerPerson.displayAllPerson();
                    break;
                case 2:
                    int choice1;
                    do {
                        System.out.println("1.Add person");
                        System.out.println("2.Add student");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");
                        choice1 = scanner.nextInt();
                        scanner.nextLine();
                        if (choice1 != 0) {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            maragerPerson.addPerson(scanner, choice1, name, age);
                        }
                    } while (choice1 != 0);
                    break;
                case 3:
                    System.out.print("Enter person's id you want to find: ");
                    int findId = scanner.nextInt();
                    maragerPerson.findById(findId);
                    break;
                case 4:
                    System.out.print("Enter person's id you want to delete: ");
                    int deleteId = scanner.nextInt();
                    maragerPerson.deleteById(deleteId);
                    break;
                case 5:
                    System.out.print("Enter person's id you want to edit: ");
                    int editId = scanner.nextInt();
                    maragerPerson.editById(editId);
                    break;
                case 6:
                    maragerPerson.rangeByAvgPoint();
                    break;
            }
        } while (choice != 0);
    }
}
