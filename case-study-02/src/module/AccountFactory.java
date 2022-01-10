package module;

import IOfiles.IOFile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountFactory implements Serializable {
    private static Pattern patternId;
    private static Pattern patternPass;
    private final IOFile<Account> accountIOFile = new IOFile<>();
    private final ArrayList<Account> accounts;
    private static final String PATH = "src/database/accounts";
    private static final String REGEX_ID = "^(?!\\d+$)\\w+$";
    private static final String REGEX_PASS = "^(\\w+)$";

    public AccountFactory() {
        accounts = accountIOFile.readFromFile(PATH);
        patternId = Pattern.compile(REGEX_ID);
        patternPass = Pattern.compile(REGEX_PASS);
    }

    private boolean validateId(String regex) {
        Matcher matcher = patternId.matcher(regex);
        return !matcher.matches();
    }

    private boolean validatePass(String regex) {
        Matcher matcher = patternPass.matcher(regex);
        return !matcher.matches();
    }

    private boolean checkExistId(String string) {
        for (Account account : accounts) {
            if (account.getUsername().equals(string)) {
                return true;
            }
        }
        return false;
    }

    public Account createAccount(String str) {
        Scanner scanner = new Scanner(System.in);
        if ("bạn tôi số 1".equalsIgnoreCase(str)) {
            String id;
            String pass;
            do {
                System.out.print("Nhập tài khoản: ");
                id = scanner.nextLine();
            } while (validateId(id) || checkExistId(id));
            do {
                System.out.print("Nhập nhập khẩu: ");
                pass = scanner.nextLine();
            } while (validatePass(pass));
            return new Account(id, pass);
        } else {
            return null;
        }
    }
}
