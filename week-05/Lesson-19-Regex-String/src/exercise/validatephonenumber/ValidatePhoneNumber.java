package exercise.validatephonenumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static Pattern pattern;

    private static final String PHONE_REGEX = "^(\\(\\d{1,2}\\)[-|\\s](\\([0](.*\\d{9})\\))$)";

    public ValidatePhoneNumber() {
        pattern = Pattern.compile(PHONE_REGEX);
    }

    public boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
