package exercise.displaynumber;

public class OddNumber implements Runnable {
    private Thread oddThread;

    public OddNumber(String name) {
        this.oddThread = new Thread(this, name);
        System.out.println(name + " thread created");;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i + ", Thread: " + oddThread.getName());
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
        System.out.println("My thread run is over");
    }
}
