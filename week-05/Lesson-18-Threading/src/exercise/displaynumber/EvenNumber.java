package exercise.displaynumber;

public class EvenNumber implements Runnable {
    private Thread evenThread;

    public EvenNumber(String name) {
        this.evenThread = new Thread(this, name);
        System.out.println(name + " thread created");;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + ", Thread: " + evenThread.getName());
                }
                Thread.sleep(15);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
        System.out.println("My thread run is over");
    }
}