package manager;

import IOfiles.IOFile;
import module.Computer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerComputer extends Thread {
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Computer> computerIOFile = new IOFile<>();
    private final ArrayList<Computer> computers;

    private static final String PATH = "src/database/computers";

    public ManagerComputer() {
        this.computers = computerIOFile.readFromFile(PATH);
    }

    public void displayAllComputer() {
        if (computers.isEmpty()) {
            System.out.println("Không có máy quản lý");
        } else {
            System.out.println();
            System.out.printf("%-10s%-10S%-15S%-15S%-15S%-15S%S\n", "No.", "Máy", "trạng thái", "giá/giờ", "giờ sử dụng", "tiền dịch vụ", "tổng tiền");
            for (int i = 0; i < computers.size(); i++) {
                System.out.printf("%-10d%-10d%-15s%-15.2f%-15.2f%-15.2f%.2f\n", (i + 1), computers.get(i).getCode(), computers.get(i).getStatus(), computers.get(i).getTimePrice(), computers.get(i).getTimeUsing(), computers.get(i).getServicePrice(), computers.get(i).totalPrice());
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
            System.out.print("Nhập số máy: ");
            code = scanner.nextInt();
            scanner.nextLine();
        Computer computer = new Computer(code);
        computers.add(computer);
        changePrice(computers.get(0).getTimePrice());
        computerIOFile.writeToFile(PATH, computers);
        return computer;
    }

    public Computer updateComputer(int updateNumber) {
        Computer computer;
        if (updateNumber <= 0 || updateNumber > computers.size()) {
            return null;
        } else {
            computer = computers.get(updateNumber - 1);
            System.out.printf("%-10S%-15S%-15S%-15S%-15S%S\n", "Máy", "trạng thái", "giá/giờ", "giờ sử dụng", "tiền dịch vụ", "tổng tiền");
            System.out.printf("%-10d%-15s%-15.2f%-15.2f%-15.2f%.2f\n", computer.getCode(), computer.getStatus(), computer.getTimePrice(), computer.getTimeUsing(), computer.getServicePrice(), computer.totalPrice());
        }
        if (computer != null) {
            int updateCode;
                System.out.print("Nhập lại số máy: ");
                updateCode = scanner.nextInt();
                scanner.nextLine();
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
        System.out.println();
        System.out.printf("%-10S%S\n", "Máy", "trạng thái");
        for (Computer computer : computers) {
            if (computer.getStatus().equals("Online")) {
                checkNull = false;
                System.out.printf("%-10s%s\n", computer.getCode(), computer.getStatus());
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
            System.out.println();
            System.out.printf("%-10S%-15S%-15S%-15S%-15S%S\n", "Máy", "trạng thái", "giá/giờ", "giờ sử dụng", "tiền dịch vụ", "tổng tiền");
            for (int i = 0; i < computers.size(); i++) {
                if (computers.indexOf(computers.get(i)) == index && computers.get(i).getStatus().equals("Online")) {
                    flag = false;
                    System.out.printf("%-10d%-15s%-15.2f%-15.2f%-15.2f%.2f\n", computers.get(i).getCode(), computers.get(i).getStatus(), computers.get(i).getTimePrice(), computers.get(i).getTimeUsing(), computers.get(i).getServicePrice(), computers.get(i).totalPrice());
                }
            }
            if (flag) {
                System.out.println("Sai dữ liệu đầu vào");
            }
        }
    }

    public boolean displayOfflineComputer() {
        boolean checkNull = true;
        System.out.println();
        System.out.printf("%-10S%S\n", "Máy", "trạng thái");
        for (Computer computer : computers) {
            if (computer.getStatus().equals("Offline")) {
                checkNull = false;
                System.out.printf("%-10s%s\n", computer.getCode(), computer.getStatus());
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
                        System.out.println("Máy " + computers.get(i).getCode() + " đang Offline. Bạn muốn bật hay không?");
                        System.out.println("1. Bật");
                        System.out.println("0. Không");
                        System.out.print("Nhập lựa chọn: ");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            computers.get(i).changeStatus();
                            computers.get(i).setStartTime(System.currentTimeMillis());
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
        if (displayOnlineComputer()) {
            System.out.println("Không có mấy nào đang online");
        } else {
            System.out.print("Nhập số máy muốn thanh toán: ");
            int index = (scanner.nextInt() - 1);

            boolean checkNull = true;

            for (int i = 0; i < computers.size(); i++) {
                if (computers.indexOf(computers.get(i)) == index && computers.get(i).getStatus().equals("Online")) {
                    checkNull = false;
                    int choice;
                    do {
                        double totalPrice = computers.get(i).totalPrice();
                        System.out.println("Bạn có muốn hay không?");
                        System.out.println("Tổng tiền: " + totalPrice + " VND");
                        System.out.println("1. Thanh toán");
                        System.out.println("0. Huỷ");
                        System.out.print("Nhập lựa chọn: ");
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            computers.get(i).changeStatus();
                            computers.get(i).setEndTime(0);
                            computers.get(i).setStartTime(0);
                            computers.get(i).setServicePrice(0);
                            System.out.println("Đã thanh toán: " + totalPrice + " VND");
//                            ghi file doanh thi
                            computerIOFile.writeToFile(PATH, computers);
                            break;
                        }
                    } while (choice != 0);
                }
            }
            if (checkNull) {
                System.out.println("Sai dữ liệu đầu vào");
            }
        }
    }

    public void addServiceToComputer(double price) {
        if (displayOnlineComputer()) {
            System.out.println("Không có mấy nào đang online");
        } else {
            System.out.print("Nhập số máy muốn thêm dịch vụ: ");
            int indexComputer = (scanner.nextInt() - 1);

            boolean checkNull = true;
            for (int i = 0; i < computers.size(); i++) {
                if (computers.indexOf(computers.get(i)) == indexComputer && computers.get(i).getStatus().equals("Online")) {
                    checkNull = false;
                    computers.get(i).setServicePrice(price);
                }
            }
            if (checkNull) {
                System.out.println("Sai dữ liệu đầu vào");
            }
        }
    }


}
