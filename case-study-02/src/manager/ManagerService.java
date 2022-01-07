package manager;

import IOfiles.IOFile;
import module.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerService {
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Service> serviceIOFile = new IOFile<>();
    private final ArrayList<Service> services;

    private static final String PATH = "src/database/services";

    public ManagerService() {
        this.services = serviceIOFile.readFromFile(PATH);
    }

    public void displayAllServices() {
        if (services.isEmpty()) {
            System.out.println("Không có dịch vụ nào");
        } else {
            System.out.println();
            System.out.printf("%-10s%-20S%S\n", "No.", "Tên", "giá");
            for (int i = 0; i < services.size(); i++) {
                System.out.printf("%-10s%-20S%.2f\n", (i + 1), services.get(i).getName(), services.get(i).getPrice());
            }
        }
    }

    public Service addService() {
        String name;
        double price;
        try {
            do {
                System.out.print("Nhập tên dịch vụ: ");
                name = scanner.nextLine();
            } while (name.equals(""));
            System.out.print("Nhập giá tiền của " + name + ": ");
            price = Double.parseDouble(scanner.nextLine());
            scanner.nextLine();
            Service service = new Service(name, price);
            services.add(service);
            serviceIOFile.writeToFile(PATH, services);
            return service;
        } catch (Exception e) {
            System.out.println("Sai dữ liệu đầu vào");
        }
        return null;
    }
}
