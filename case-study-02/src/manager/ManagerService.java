package manager;

import IOfiles.IOFile;
import module.Computer;
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
    private static final String REGEX_INPUT = "^(?!\\d+$)\\w+$";
    private static final String REGEX_NUMBER = "^(\\w+)$";

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
            for (int i = 0; i < services.size(); i++) {
                System.out.println((i + 1) + ". " + services.get(i).toString());
            }
        }
    }
}
