package exercise.validatephonenumber;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ValidatePhoneNumber validateClassName = new ValidatePhoneNumber();
        ArrayList<String> phoneList = new ArrayList<>();
        phoneList.add("(84)-(0978489648)");
        phoneList.add("(84) (0978489648)");
        phoneList.add("(a8)-(22222222)");

        for (String str : phoneList) {
            boolean flag = validateClassName.validate(str);
            System.out.println(str + ", Validate: " + flag);
        }

    }
}
