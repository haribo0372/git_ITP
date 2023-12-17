package first;

public class MyThread extends Thread {
    private final int[] array;
    private final Sum sum;

    public MyThread(int[] array, Sum sum) {
        this.array = array;
        this.sum = sum;
        start();
    }

    @Override
    public void run() {
        for (int i : array) {
            sum.increment(i);
        }
    }
}
