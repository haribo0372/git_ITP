package first;

public class Sum {
    private int sum;

    public synchronized void increment(int a) {
        sum += a;
    }

    public int getSum() {
        return sum;
    }
}
