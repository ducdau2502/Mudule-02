package module;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountFactory {
    private static Pattern pattern;
    private static final String REGEX = "^(?!\\d+$)\\w+$";

    public AccountFactory() {
        pattern = Pattern.compile(REGEX);
    }

    private boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }

    public Account createAccount(String str) {
        Scanner scanner = new Scanner(System.in);
        if ("abc".equals(str)) {
            String id;
            String pass;
            do {
                System.out.print("Nhập tài khoản: ");
                id = scanner.nextLine();
            } while (validate(id));
            do {
                System.out.print("Nhập nhập khẩu: ");
                pass = scanner.nextLine();
            } while (validate(pass));
            return new Account(id, pass);
        } else {
            return null;
        }
    }
}
