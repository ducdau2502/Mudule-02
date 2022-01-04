package main;

import IOfiles.IOFile;
import module.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String PATH_ACCOUNT = "src/database/accounts";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainAccount mainAccount = new MainAccount();
        MainComputer mainComputer = new MainComputer();
        IOFile<Account> accountIOFile = new IOFile<>();
        ArrayList<Account> accounts = accountIOFile.readFromFile(PATH_ACCOUNT);
        System.out.println("Mời đăng nhập để vào mục quản lý");
        System.out.print("Nhập tài khoản: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        boolean checkLogin = checkUsername(accounts, username) && checkPassword(accounts, password);

        if (checkLogin) {
            System.out.println("Đăng nhập thành công");
            int choice;
            do {
                System.out.println("QUẢN LÝ CYBER GAMING");
                System.out.println("1. Quản lý tài khoản");
                System.out.println("2. Quản lý phòng máy");
                System.out.println("0. Thoát hệ thống");
                System.out.print("NHập vào lựa chọn của bạn: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        mainAccount.runMainAccount();
                        break;
                    case 2:
                        mainComputer.runMainComputer();
                        break;
                }
            } while (choice != 0);
        } else {
            System.out.println("Đăng nhập thất bại");
        }
    }

    private static boolean checkUsername(ArrayList<Account> accounts, String string) {
        for (Account account : accounts) {
            if (account.getUsername().equals(string)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPassword(ArrayList<Account> accounts, String string) {
        for (Account account : accounts) {
            if (account.getPassword().equals(string)) {
                return true;
            }
        }
        return false;
    }
}

