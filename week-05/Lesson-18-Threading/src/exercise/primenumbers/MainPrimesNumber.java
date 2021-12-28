package exercise.primenumbers;

public class MainPrimesNumber {
    public static void main(String[] args) {
        LazyPrimeFactorization lazy = new LazyPrimeFactorization("Lazy");
        OptimizedPrimeFactorization optimize = new OptimizedPrimeFactorization("optimize");

        Thread thread1 = new Thread(lazy);
        Thread thread2 = new Thread(optimize);

        thread2.start();
        thread1.start();
    }
}
