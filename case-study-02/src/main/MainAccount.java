package main;

import manager.ManagerAccount;
import module.Account;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainAccount {
    private final Scanner scanner = new Scanner(System.in);
    private static Pattern pattern;
    private static final String NUMBER_REGEX = "^(\\d+)$";
    ManagerAccount managerAccount = new ManagerAccount();

    public MainAccount() {
        pattern = Pattern.compile(NUMBER_REGEX);
    }

    private boolean validateNumber(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }

    public void runMainAccount() {
        int choice;
        do {
            do {
                System.out.println("QUẢN LÝ TÀI KHOẢN");
                System.out.println("1. Hiển thị toàn bộ tài khoản quản lý");
                System.out.println("2. Thêm tài khoản quản lý");
                System.out.println("3. Sửa thông tin tài khoản quản lý");
                System.out.println("4. Xoá tài khoản quản lý");
                System.out.println("0. Quay lại");
                System.out.print("Nhập vào lựa chọn của bạn: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            } while (validateNumber(Integer.toString(choice)) || choice < 0 || choice > 4);

            switch (choice) {
                case 1:
                    managerAccount.displayALlAccount();
                    break;
                case 2:
                    Account createAccount = managerAccount.addAccount();
                    if (createAccount != null) {
                        System.out.println("Tạo tài khoản " + createAccount.getUsername() + " thành công");
                    } else {
                        System.out.println("Tạo tài khoản thất bại");
                    }
                    break;
                case 3:
                    managerAccount.displayALlAccount();
                    updateAccount();
                    break;
                case 4:
                    managerAccount.displayALlAccount();
                    deleteAccount();
                    break;
            }


        } while (choice != 0);
    }

    private void deleteAccount() {
        int deleteNumber;
        do {
            System.out.print("Nhập vào số thứ tự của tài khoản: ");
            deleteNumber = scanner.nextInt();
        } while (validateNumber(Integer.toString(deleteNumber)));
        int choice1;
        do {
            System.out.println("1. Xoá");
            System.out.println("0. Không");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice1 = scanner.nextInt();
            scanner.nextLine();
        } while (validateNumber(Integer.toString(choice1)) || choice1 < 0 || choice1 > 1);
        if (choice1 == 1) {
            Account account = managerAccount.deleteAccount(deleteNumber);
            if (account != null) {
                System.out.println("Xoá tài khoản " + account.getUsername() + " thành công");
            } else {
                System.out.println("Xoá tài khoản thất bại");
            }
        }
    }

    private void updateAccount() {
        int updateNumber;
        do {
            System.out.print("Nhập vào số thứ tự của tài khoản: ");
            updateNumber = scanner.nextInt();
        } while (validateNumber(Integer.toString(updateNumber)));
        Account account = managerAccount.updateAccount(updateNumber);
        if (account != null) {
            System.out.println("Sửa tài khoản " + account.getUsername() + " thành công");
        } else {
            System.out.println("Sửa tài khoản thất bại");
        }
    }
}
