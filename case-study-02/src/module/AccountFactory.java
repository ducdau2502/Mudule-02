package module;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountFactory implements Serializable {
    private static Pattern patternId;
    private static Pattern patternPass;
    private static final String REGEX_ID = "^(?!\\d+$)\\w+$";
    private static final String REGEX_PASS = "^(\\w+)$";

    public AccountFactory() {
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

    public Account createAccount(String str) {
        Scanner scanner = new Scanner(System.in);
        if ("abc".equalsIgnoreCase(str)) {
            String id;
            String pass;
            do {
                System.out.print("Nhập tài khoản: ");
                id = scanner.nextLine();
            } while (validateId(id));
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
