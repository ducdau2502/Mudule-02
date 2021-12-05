import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Day of month");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month that you want to count days? ");
        int month = scanner.nextInt();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.printf("The month %d has 31 days!", month);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.printf("The month %d has 30 days!", month);
                break;
            case 2:
                System.out.printf("The month %d has 28 or 29 days!", month);
                break;
        }
    }
}
