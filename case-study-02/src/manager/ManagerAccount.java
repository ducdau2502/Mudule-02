package manager;

import IOfiles.IOFile;
import module.Account;
import module.AccountFactory;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerAccount {
    private final Scanner scanner = new Scanner(System.in);
    private final AccountFactory accountFactory = new AccountFactory();
    private final IOFile<Account> accountIOFile = new IOFile<>();
    private final ArrayList<Account> accounts;
    private static Pattern pattern;
    private static final String REGEX = "^(?!\\d+$)\\w+$";
    private static final String PATH = "src/database/accounts";

    public ManagerAccount() {
        pattern = Pattern.compile(REGEX);
        accounts = accountIOFile.readFromFile(PATH);
    }

    private boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }

    public void displayALlAccount() {
        if (accounts.isEmpty()) {
            System.out.println("Không có tài khoản quản lý");
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println((i + 1) + ". " + accounts.get(i).toString());
            }
        }
    }

    public Account deleteAccount(int deleteNumber) {
        Account account;
        if (deleteNumber < 0 || deleteNumber > accounts.size()) {
            account = null;
        } else {
            account = accounts.get(deleteNumber - 1);
            accounts.remove(account);
            accountIOFile.writeToFile(PATH, accounts);
        }
        return account;
    }

    public Account addAccount() {
        System.out.print("Nhập pass: ");
        String pass = scanner.nextLine();
        Account account = accountFactory.createAccount(pass);
        if (account != null) {
            accounts.add(account);
            accountIOFile.writeToFile(PATH, accounts);
        }
        return account;
    }

    public Account updateAccount(int updateNumber) {
        Account account;
        if (updateNumber < 0 || updateNumber > accounts.size()) {
            return null;
        } else {
            account = accounts.get(updateNumber - 1);
            System.out.println(account);
        }

        if (account != null) {
            String updateId;
            String updatePassword;
            do {
                System.out.print("Nhập lại tài khoản: ");
                updateId = scanner.nextLine();
            } while (validate(updateId) || checkExistId(updateId));
            account.setUsername(updateId);
            do {
                System.out.print("Nhập lại mật khẩu: ");
                updatePassword = scanner.nextLine();
            } while (validate(updatePassword) || checkExistPassword(updatePassword));
            account.setPassword(updatePassword);
            accounts.set(updateNumber - 1, account);
        }
        accountIOFile.writeToFile(PATH, accounts);
        return account;
    }

    private boolean checkExistId(String string) {
        for (Account account : accounts) {
            if (account.getUsername().equals(string)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExistPassword(String string) {
        for (Account account : accounts) {
            if (account.getPassword().equals(string)) {
                return true;
            }
        }
        return false;
    }


}
