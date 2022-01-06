package manager;

import IOfiles.IOFile;
import module.Computer;
import module.Turnover;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagerComputer extends Thread {
    private final Scanner scanner = new Scanner(System.in);
    private final IOFile<Computer> computerIOFile = new IOFile<>();
    private final ArrayList<Computer> computers;
    private final ArrayList<Turnover> turnovers;

    private static final String PATH = "src/database/computers";
    private static final String PATH_TURNOVER = "src/database/turnovers";

    public ManagerComputer() {
        this.computers = computerIOFile.readFromFile(PATH);
        this.turnovers = readFileCSV(PATH_TURNOVER);

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
                            Date date = new Date((long) computers.get(i).getEndTime());
                            int day = date.getDate();
                            int month = date.getMonth() + 1;
                            int year = date.getYear() + 1900;
                            turnovers.add(new Turnover(day, month, year, totalPrice));
                            computers.get(i).setEndTime(0);
                            computers.get(i).setStartTime(0);
                            computers.get(i).resetServicePrice();
                            System.out.println("Đã thanh toán: " + totalPrice + " VND");

                            writeFileCSV(turnovers, PATH_TURNOVER);
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

    public double totalTurnover() {
        double sum = 0;
        for(Turnover turnover : turnovers) {
            sum += turnover.getTurnover();
        }

        return sum;
    }

    private void writeFileCSV(ArrayList<Turnover> turnovers, String path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (Turnover turnover : turnovers) {
                bufferedWriter.append(String.valueOf(turnover.getDay()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(turnover.getMonth()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(turnover.getYear()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(turnover.getTurnover()));
                bufferedWriter.append("\n");
            }

            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private ArrayList<Turnover> readFileCSV(String path) {
        ArrayList<Turnover> turnovers = new ArrayList<>();
        File file = new File(path);

        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] strings = line.split(",");
                    int day = Integer.parseInt(strings[0]);
                    int month = Integer.parseInt(strings[1]);
                    int year = Integer.parseInt(strings[2]);
                    double turnover = Double.parseDouble(strings[3]);
                    turnovers.add(new Turnover(day, month, year, turnover));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return turnovers;
    }


}
