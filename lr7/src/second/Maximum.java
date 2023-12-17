package second;

public class Maximum {
    private int max;

    public synchronized void changeMax(int a) {
        max = max > a ? max : a;
    }

    public int getMax() {
        return max;
    }
}
