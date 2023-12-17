package third;

public class SumKG {
    private int sum;

    public SumKG(){
        sum = 0;
    }
    public synchronized void increment(int a) {
        sum += a;
    }

    public int getSum() {
        return sum;
    }
}
