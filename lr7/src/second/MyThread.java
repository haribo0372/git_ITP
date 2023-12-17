package second;

public class MyThread extends Thread {
    private final int[] array;
    private final Maximum max;

    public MyThread(int[] array, Maximum m) {
        this.array = array;
        max = m;
    }

    @Override
    public void run() {
        for (int i : array) {
            max.changeMax(i);
        }
    }
}
