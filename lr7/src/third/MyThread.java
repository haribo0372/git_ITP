package third;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread extends Thread {
    private final CyclicBarrier barrier;
    private final Warehouse warehouse;
    private final SumKG OldSum;
    private int sum;

    public MyThread(CyclicBarrier cyclicBarrier, Warehouse wh, SumKG sumKG) {
        barrier = cyclicBarrier;
        warehouse = wh;
        OldSum = sumKG;
        sum = 0;
        start();
    }

    @Override
    public void run() {
        while (sum <= 150 && !warehouse.stack.empty()) {
            int x = warehouse.stack.pop();
            OldSum.increment(x);
            sum += x;
        }
        try {
            barrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
