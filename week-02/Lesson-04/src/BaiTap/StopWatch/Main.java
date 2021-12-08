package BaiTap.StopWatch;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        StopWatch sw = new StopWatch();

        sw.start();
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
        }
        sw.stop();

        System.out.println("Time: " + sw.getElapsedTime());
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tempt = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tempt;
                }
            }
        }
    }

}
