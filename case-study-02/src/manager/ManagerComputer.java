package manager;

import IOfiles.IOFile;
import module.Account;
import module.Computer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerComputer {
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Computer> computerIOFile = new IOFile<>();
    private final ArrayList<Computer> computers;
    private static Pattern patternNumber;
    private static final String REGEX_NUMBER = "^(\\d+)$";

    private static final String PATH = "src/database/computers";

    public ManagerComputer() {
        patternNumber = Pattern.compile(REGEX_NUMBER);
        this.computers = computerIOFile.readFromFile(PATH);
    }

    private boolean validateNumber(String regex) {
        Matcher matcher = patternNumber.matcher(regex);
        return !matcher.matches();
    }

    public void displayAllComputer() {
        if (computers.isEmpty()) {
            System.out.println("Không có máy quản lý");
        } else {
            for (int i = 0; i < computers.size(); i++) {
                System.out.println((i + 1) + ". " + computers.get(i).toString());
            }
        }
    }

    public void displayOnlineComputer() {
        for (Computer computer : computers) {
            if (computer.getStatus().equals("Online")) {
                System.out.println(computer);
            }
        }
    }

    public void displayOfflineComputer() {
        for (Computer computer : computers) {
            if (computer.getStatus().equals("Offline")) {
                System.out.println(computer);
            }
        }
    }

    public Computer deleteComputer(int deleteNum) {
        Computer computer;
        if (deleteNum > 0 && deleteNum <= computers.size()) {
            computer = computers.get(deleteNum - 1);
            computers.remove(computer);
            computerIOFile.writeToFile(PATH, computers);
        } else {
            computer = null;
        }
        return computer;
    }

    private boolean checkCode(int code) {
        for (Computer computer : computers) {
            if (computer.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public Computer addComputer() {
        int code;
        do {
            System.out.print("Nhập số máy: ");
            code = scanner.nextInt();
            scanner.nextLine();
        } while (checkCode(code));
        Computer computer = new Computer(code);
        computers.add(computer);
        computerIOFile.writeToFile(PATH, computers);
        return computer;
    }

    public Computer updateComputer(int updateNumber) {
        Computer computer;
        if (updateNumber < 0 || updateNumber > computers.size()) {
            return null;
        } else {
            computer = computers.get(updateNumber - 1);
            System.out.println(computers);
        }

        if (computer != null) {
            int updateCode;
            do {
                System.out.print("Nhập lại số máy: ");
                updateCode = scanner.nextInt();
                scanner.nextLine();
            } while (validateNumber(Integer.toString(updateCode)) || checkCode(updateCode));
            computer.setCode(updateCode);

            computers.set(updateNumber - 1, computer);
        }
        computerIOFile.writeToFile(PATH, computers);
        return computer;
    }

    public void changePrice(double price) {
        for (Computer computer : computers) {
            computer.setPrice(price);
        }
    }

}
