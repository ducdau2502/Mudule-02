package exercise.simplethread;

public class NumberGenerator implements Runnable {
    private final Thread myThread;

    public NumberGenerator(String name) {
        myThread = new Thread(this, name);
        System.out.println("my thread created" + myThread);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " Thead name: " + myThread.getName() + ", hashcode: " + myThread.hashCode() + ", priority: " + myThread.getPriority());
                Thread.sleep(500);
            }
        } catch (InterruptedException ie) {
            System.out.println("my thread interrupted");
        }
        System.out.println("my thread run is over");
    }
}
