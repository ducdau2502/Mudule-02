package manager;

import IOfiles.IOFile;
import module.Service;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerService {
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Service> serviceIOFile = new IOFile<>();
    private final ArrayList<Service> services;
    private static Pattern patternInput;
    private static Pattern patternNumber;
    private static final String REGEX_INPUT = "^([a-zA-Z])(.*\\w+)$";
    private static final String REGEX_NUMBER = "^(\\d+)$";

    private static final String PATH = "src/database/services";

    public ManagerService() {
        patternInput = Pattern.compile(REGEX_INPUT);
        patternNumber = Pattern.compile(REGEX_NUMBER);
        this.services = serviceIOFile.readFromFile(PATH);
    }

    private boolean validateInput(String regex) {
        Matcher matcher = patternInput.matcher(regex);
        return matcher.matches();
    }
    private boolean validateNumber(String regex) {
        Matcher matcher = patternNumber.matcher(regex);
        return matcher.matches();
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
        do {
            System.out.print("Nhập tên dịch vụ: ");
            name = scanner.nextLine();
        } while (validateInput(name));
        do {
            System.out.print("Nhập giá tiền của " + name + ": ");
            price = scanner.nextDouble();
            scanner.nextLine();
        } while (validateNumber(Double.toString(price)));
        Service service = new Service(name, price);
        services.add(service);
        serviceIOFile.writeToFile(PATH, services);
        return service;
    }
}
