package exercise.validateclassname;

import java.util.ArrayList;

public class MainClassName {
    public static void main(String[] args) {
        ValidateClassName validateClassName = new ValidateClassName();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("C0318G");
        arrayList.add("M0318G");
        arrayList.add("P0323A");

        for (String str : arrayList) {
            boolean flag = validateClassName.validate(str);
            System.out.println(str + ", Validate: " + flag);
        }
    }
}
