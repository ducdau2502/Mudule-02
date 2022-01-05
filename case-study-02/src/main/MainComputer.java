package main;

import manager.ManagerComputer;
import manager.ManagerService;
import module.Computer;
import module.Service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainComputer {
    private final Scanner scanner = new Scanner(System.in);
    private static Pattern pattern;
    private static final String NUMBER_REGEX = "^(\\d+)$";
    ManagerComputer managerComputer = new ManagerComputer();
    ManagerService managerService = new ManagerService();

    public MainComputer() {
        pattern = Pattern.compile(NUMBER_REGEX);
    }

    private boolean validateNumber(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }

    public void runMainComputer() {
        int choice;
        do {
            do {
                System.out.println("QUẢN LÝ PHÒNG MÁY");
                System.out.println("1. Hiển thị toàn bộ máy trong quán");
                System.out.println("2. Thêm 1 máy vào danh sách");
                System.out.println("3. Sửa thông tin máy");
                System.out.println("4. Xoá 1 máy khỏi danh sách");
                System.out.println("5. Thêm dịch vụ");
                System.out.println("6. Hiển thị tất cả dịch vụ");
                System.out.println("7. Chỉnh sửa tính tiền theo giờ");
                System.out.println("8. Tính tiền");
                System.out.println("9. Doanh thu");
                System.out.println("0. Quay lại");
                System.out.print("Nhập vào lựa chọn của bạn: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            } while (validateNumber(Integer.toString(choice)) || choice < 0 || choice > 9);

            switch (choice) {
                case 1:
                    displayComputer();
                    break;
                case 2:
                    Computer computer = managerComputer.addComputer();
                    if (computer != null) {
                        System.out.println("Tạo máy " + computer.getCode() + " thành công");
                    } else {
                        System.out.println("Tạo tài khoản thất bại");
                    }
                    break;
                case 3:
                    managerComputer.displayAllComputer();
                    updateComputer();
                    break;
                case 4:
                    managerComputer.displayAllComputer();
                    deleteComputer();
                    break;
                case 5:
                    Service service = managerService.addService();
                    if (service != null) {
                        System.out.println("Thêm " + service.getName() + " thành công");
                    } else {
                        System.out.println("Thêm thất bại");
                    }
                    break;
                case 6:
                    managerService.displayAllServices();
                    break;
                case 7:
                    System.out.print("Nhập số tiền 1 giờ/máy: ");
                    double price = scanner.nextDouble();
                    managerComputer.changePrice(price);
                    break;
                case 8:
                    int choice1;
                    do {
                        do {
                            System.out.println("1. Thanh toán");
                            System.out.println("2. Thêm dịch vụ");
                            System.out.println("0. Quay lại");
                            System.out.print("Nhập vào lựa chọn của bạn: ");
                            choice1 = scanner.nextInt();
                            scanner.nextLine();

                        } while (validateNumber(Integer.toString(choice1)) || choice1 < 0 || choice1 > 2);
                        if (choice1 == 1) {
                            managerComputer.displayOnlineComputer();
                        } else {
                            managerComputer.displayOfflineComputer();
                        }
                    } while (choice1 != 0);
                    break;
                case 9:
                    break;
            }
        } while (choice != 0);
    }

    private void displayComputer() {
        int choice1;
        do {
            do {
                System.out.println("1. Hiển thị toàn bộ máy online");
                System.out.println("2. Hiển thị toàn bộ máy offline");
                System.out.println("0. Quay lại");
                System.out.print("Nhập vào lựa chọn của bạn: ");
                choice1 = scanner.nextInt();
                scanner.nextLine();

            } while (validateNumber(Integer.toString(choice1)) || choice1 < 0 || choice1 > 2);
            if (choice1 == 1) {
//                managerComputer.displayOnlineComputer();
                managerComputer.displayDetails();
            } else if (choice1 == 2) {
//                managerComputer.displayOfflineComputer();
                managerComputer.turnOnComputer();
            }
        } while (choice1 != 0);
    }

    private void deleteComputer() {
        int deleteNumber;
        do {
            System.out.print("Nhập vào số thứ tự của máy: ");
            deleteNumber = scanner.nextInt();
        } while (validateNumber(Integer.toString(deleteNumber)));
        int choice1;
        do {
            System.out.println("1. Xác nhận xoá");
            System.out.println("0. Không xoá");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice1 = scanner.nextInt();
            scanner.nextLine();
        } while (validateNumber(Integer.toString(choice1)) || choice1 < 0 || choice1 > 1);
        if (choice1 == 1) {
            Computer computer = managerComputer.deleteComputer(deleteNumber);
            if (computer != null) {
                System.out.println("Xoá máy " + computer.getCode() + " thành công");
            } else {
                System.out.println("Xoá máy thất bại");
            }
        }
    }

    private void updateComputer() {
        int updateNumber;
        do {
            System.out.print("Nhập vào số thứ tự của máy: ");
            updateNumber = scanner.nextInt();
        } while (validateNumber(Integer.toString(updateNumber)));
        Computer computer = managerComputer.updateComputer(updateNumber);
        if (computer != null) {
            System.out.println("Sửa máy " + computer.getCode() + " thành công");
        } else {
            System.out.println("Sửa máy thất bại");
        }
    }
}
