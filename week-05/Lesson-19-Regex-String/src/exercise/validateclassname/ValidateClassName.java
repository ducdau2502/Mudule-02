package exercise.validateclassname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    private static Pattern pattern;

    private static final String CLASS_NAME_REGEX = "^(?=[CAP])(.*\\d{4})(.*[GHIKLM]$)";

    public ValidateClassName() {
        pattern = Pattern.compile(CLASS_NAME_REGEX);
    }

    public boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
