package third;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args){
        SumKG kg = new SumKG();
        Warehouse warehouse = new Warehouse();
        CyclicBarrier barrier = new CyclicBarrier(3, new Run(kg));
        new MyThread(barrier, warehouse, kg);
        new MyThread(barrier, warehouse, kg);
        new MyThread(barrier, warehouse, kg);
    }
}
