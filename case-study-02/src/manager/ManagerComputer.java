package manager;

import IOfiles.IOFile;
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
        changePrice(computers.get(0).getTimePrice());
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
            computer.setTimePrice(price);
        }
    }

    public boolean displayOnlineComputer() {
        boolean checkNull = true;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getStatus().equals("Online")) {
                checkNull = false;
                System.out.println("máy " + computers.get(i).getCode() + " " + computers.get(i).getStatus());
            }
        }
        return checkNull;
    }

    public void displayDetails() {
        if (displayOnlineComputer()) {
            System.out.println("Không có máy nào đang Online");
        } else {
            System.out.print("Nhập số máy muốn xem chi tiết ");
            int index = (scanner.nextInt() - 1);

            boolean flag = true;

            for (int i = 0; i < computers.size(); i++) {
                if (computers.indexOf(computers.get(i)) == index && computers.get(i).getStatus().equals("Online")) {
                    flag = false;
                    System.out.println(computers.get(i).toString());
                }
            }
            if (flag) {
                System.out.println("Sai dữ liệu đầu vào");
            }
        }
    }

    public boolean displayOfflineComputer() {
        boolean checkNull = true;
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getStatus().equals("Offline")) {
                checkNull = false;
                System.out.println("máy " + computers.get(i).getCode() + " " + computers.get(i).getStatus());
            }
        }

        return checkNull;
    }

    public void turnOnComputer() {
        if (displayOfflineComputer()) {
            System.out.println("Không có mấy nào đang offline");
        } else {
            System.out.print("Nhập số máy muốn bật: ");
            int index = (scanner.nextInt() - 1);

            boolean flag = true;

            for (int i = 0; i < computers.size(); i++) {
                if (computers.indexOf(computers.get(i)) == index && computers.get(i).getStatus().equals("Offline")) {
                    flag = false;
                    int choice;
                    do {
                        System.out.println("Máy đang Offline. Bạn muốn bật hay không?");
                        System.out.println("1. Bật");
                        System.out.println("0. Không");
                        System.out.print("Nhập lựa chọn: ");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            computers.get(i).changeStatus();
                            computers.get(i).setStartTime();
                            computers.get(i).start();
                            computerIOFile.writeToFile(PATH, computers);
                            break;
                        }
                    } while (choice != 0);
                }
            }
            if (flag) {
                System.out.println("Sai dữ liệu đầu vào");
            }
        }
    }

    public void payment() {

    }
}
