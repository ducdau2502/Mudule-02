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
        while (true) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t------PHẦN MỀM QUẢN LÝ PHÒNG NET------");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----------Hệ thống-----------\n");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t---Mời đăng nhập để vào mục quản lý---\n");
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\tNhập tài khoản: ");
            String username = scanner.nextLine();
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\tNhập mật khẩu: ");
            String password = scanner.nextLine();

            boolean checkLogin = checkUsername(accounts, username) && checkPassword(accounts, password);
            if (checkLogin) {
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----Đăng nhập thành công-----");
                int choice;
                do {
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t********** CYBER GAME ***********");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t*     1. Quản lý tài khoản      *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t*     2. Quản lý phòng máy      *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t*     0. Thoát hệ thống         *");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t*********************************");
                    System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\tNhập vào lựa chọn của bạn: ");
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                mainAccount.runMainAccount();
                                break;
                            case 2:
                                mainComputer.runMainComputer();
                                break;
                            case 0:
                                System.exit(0);
                        }
                    } catch (Exception e) {
                        System.err.println("\t\t\t\t\t\t\t\t\t\t\t\t\t--Có biết là phải nhập số không--");
                    }
                } while (true);
            } else {
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----Đăng nhập thất bại-----");
            }
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

