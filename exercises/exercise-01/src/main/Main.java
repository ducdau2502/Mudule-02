package main;

import manager.ManagerCustomer;
import manager.ManagerHotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerCustomer managerCustomer = new ManagerCustomer();
        ManagerHotel managerHotel = new ManagerHotel();

        int choice;
        do {
            System.out.println("Manu Bar");
            System.out.println("1. Add rent room");
            System.out.println("2. Edit rent room");
            System.out.println("3. Display rent room");
            System.out.println("4. Calculate money");
            System.out.println("5. Edit customer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managerHotel.addRentRoom(managerCustomer);
                    break;
                case 2:
                    System.out.print("Enter customer's id you want to update room information: ");
                    long updateId = scanner.nextLong();
                    System.out.println(managerHotel.editRentRoom(updateId));
                    break;
                case 3:
                    managerHotel.displayRentRoom();
                    break;
                case 4:
                    System.out.print("Enter customer's id want to pay: ");
                    long id = scanner.nextLong();
                    System.out.printf("%-15S %S \n", "full name", "price");
                    System.out.println(managerHotel.calculateMoney(id));
                    break;
                case 5:
                    System.out.print("Enter customer's id you want to edit: ");
                    long editId = scanner.nextLong();
                    scanner.nextLine();
                    managerCustomer.editById(editId);
                    break;
            }

        } while (choice != 0);
    }
}
