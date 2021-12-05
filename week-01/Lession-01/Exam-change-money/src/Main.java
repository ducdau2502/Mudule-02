import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;

        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập vào 1 số tiền USD: ");
        usd = scanner.nextDouble();

        double quyDoi = vnd * usd;

        System.out.println("Số tiền VND là: " + quyDoi);
    }
}
