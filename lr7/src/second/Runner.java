package second;

import java.util.ArrayList;
import java.util.List;

public class Runner implements Runnable {
    @Override
    public void run() {
        int[][] a = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        Maximum maximum = new Maximum();
        List<MyThread> list = new ArrayList<>();
        for (int[] ints : a) {
            MyThread thread = new MyThread(ints, maximum);
            list.add(thread);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        printResult(a, maximum);
    }

    private void printResult(int[][] a, Maximum maximum) {
        System.out.print("matrix :\n\n");
        for (int[] ar : a) {
            for (int el : ar) {
                System.out.print("\t" + el);
            }
            System.out.println();
        }
        System.out.println("\nMax(matrix) = " + maximum.getMax());
    }
}
