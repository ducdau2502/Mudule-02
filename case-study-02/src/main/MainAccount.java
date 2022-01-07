package main;

import manager.ManagerAccount;
import module.Account;

import java.util.Scanner;

public class MainAccount {
    private final Scanner scanner = new Scanner(System.in);
    ManagerAccount managerAccount = new ManagerAccount();

    public MainAccount() {
    }

    public void runMainAccount() {
        int choice;
        boolean flag = true;
        while (flag) {
            try {
                do {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t##==================QUẢN LÝ TÀI KHOẢN==================##");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t||    1. Hiển thị toàn bộ tài khoản quản lý            ||");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t||    2. Thêm tài khoản quản lý                        ||");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t||    3. Sửa thông tin tài khoản quản lý               ||");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t||    4. Xoá tài khoản quản lý                         ||");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t||    0. Quay lại                                      ||");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t##=======================*****=========================##");
                    System.out.print("\t\t\t\t\t\t\t\t\t\tNhập vào lựa chọn của bạn: ");

                    choice = Integer.parseInt(scanner.nextLine());

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
                        case 0:
                            flag = false;
                            break;
                    }
                } while (choice != 0);
            } catch (Exception e) {
                System.err.println("\t\t\t\t\t\t\t\t\t\t_-_-_-_-_-_-_-_Nhập số đúng vào đi bạn ơi_-_-_-_-_-_-_-_");
            }
        }


    }

    private void deleteAccount() {
        int deleteNumber;
            System.out.print("Nhập vào số thứ tự của tài khoản: ");
            deleteNumber = Integer.parseInt(scanner.nextLine());
        int choice1;
            System.out.println("1. Xoá");
            System.out.println("0. Không");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice1 = Integer.parseInt(scanner.nextLine());
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
            System.out.print("Nhập vào số thứ tự của tài khoản: ");
            updateNumber = Integer.parseInt(scanner.nextLine());
        Account account = managerAccount.updateAccount(updateNumber);
        if (account != null) {
            System.out.println("Sửa tài khoản " + account.getUsername() + " thành công");
        } else {
            System.out.println("Sửa tài khoản thất bại");
        }
    }
}
