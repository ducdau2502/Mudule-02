package exercise.primenumbers;

public class LazyPrimeFactorization implements Runnable {
    private final Thread myThread;

    public LazyPrimeFactorization(String name) {
        myThread = new Thread(this, name);
        System.out.println("my thread created" + name);
    }

    @Override
    public void run() {
        int number = 2;
        int countPrimes = 200;

        while (number < countPrimes) {
            boolean flag = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(number + " " + myThread.getName() + "\n");
            }
            number++;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
