package manager;

import module.Customer;
import module.Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerHotel {
    private ArrayList<Hotel> rooms;
    private Scanner scanner;

    public ManagerHotel() {
        this.rooms = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addRentRoom(ManagerCustomer mg) {
        System.out.print("Enter day want to rent: ");
        int numberStay = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kind of room: ");
        String kindOfRoom = scanner.nextLine();
        System.out.print("Price of room: ");
        double price = scanner.nextDouble();
        Customer customer = mg.addCustomer();
        rooms.add(new Hotel(numberStay, kindOfRoom, price, customer));
    }

    public Hotel editRentRoom(long id) {
        Hotel room = null;
        for (Hotel r : rooms) {
            if (r.getCustomer().getId() == id) {
                room = r;
            }
        }
        if (room != null) {
            int index = rooms.indexOf(room);
            System.out.print("Update day want to rent: ");
            int numberStay = scanner.nextInt();
            room.setNumberStay(numberStay);
            scanner.nextLine();
            System.out.print("Kind of room: ");
            String kindOfRoom = scanner.nextLine();
            room.setKindOfRoom(kindOfRoom);
            System.out.print("Price of room: ");
            double price = scanner.nextDouble();
            room.setPriceOfRoom(price);
            rooms.set(index, room);
        }
        System.out.printf("%-15S %-15S %-15S %-15S %-15S %S \n", "days rent", "kind of room", "price", "full name", " date of birth", "identity card");
        return room;
    }

    public void displayRentRoom() {
        System.out.printf("%-15S %-15S %-15S %-15S %-15S %S \n", "days rent", "kind of room", "price", "full name", " date of birth", "identity card");
        for (Hotel room : rooms) {
            System.out.println(room);
        }
    }

    public String calculateMoney(long id) {
        Hotel room = null;
        for (Hotel r : rooms) {
            if (r.getCustomer().getId() == id) {
                room = r;
            }
        }
        if (room != null) {
            double money = room.getPriceOfRoom() * room.getNumberStay();
            rooms.remove(room);
            return String.format("%-15s %f", room.getCustomer().getFullName(), money);

        }
        return "";
    }
}
