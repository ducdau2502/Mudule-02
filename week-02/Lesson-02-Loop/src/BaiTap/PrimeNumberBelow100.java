package BaiTap;

public class PrimeNumberBelow100 {
    public static void main(String[] args) {

        int number = 2;
        int countPrimes = 100;

        while (number < countPrimes) {
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print(number + ", ");
            }

            number++;
        }
    }
}
