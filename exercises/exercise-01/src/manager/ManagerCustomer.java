package manager;

import module.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerCustomer {
    private ArrayList<Customer> customers;
    private Scanner scanner;

    public ManagerCustomer() {
        customers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public Customer addCustomer() {
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter date of birth: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter identity card number: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        Customer customer = new Customer(fullName, dateOfBirth, id);
        customers.add(customer);
        return customer;
    }

    public void displayAllCustomer() {
        System.out.println(customers);
    }

    public void displayCustomerById(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.println(customer);
            } else {
                System.out.println("Name not found...!!!");
            }
        }
    }

    public Customer deleteById(long id) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId() == id) {
                customer = c;
            }
        }
        int index = customers.indexOf(customer);
        return customers.remove(index);
    }

    public Customer editById(long editId) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId() == editId) {
                customer = c;
            }
        }
        if (customer != null) {
            int index = customers.indexOf(customer);
            System.out.print("Update full name: ");
            String fullName = scanner.nextLine();
            customer.setFullName(fullName);
            System.out.print("Update date of birth: ");
            String dateOfBirth = scanner.nextLine();
            customer.setDateOfBirth(dateOfBirth);
            System.out.print("Update identity card number: ");
            long id = scanner.nextLong();
            customer.setId(id);
            customers.set(index, customer);
        }
        return customer;
    }

}
