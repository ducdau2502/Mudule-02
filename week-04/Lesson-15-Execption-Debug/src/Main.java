
public class Main {

    public static void main(String[] args) {
        Main.recursivePrint(1);
    }

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);

        if (num == 0)
            return;
        else
            recursivePrint(++num);
    }
}

