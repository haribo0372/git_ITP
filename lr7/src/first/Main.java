package first;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sum sum = new Sum();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        MyThread thread1 = new MyThread(Arrays.copyOfRange(array, 0, array.length / 2), sum);
        MyThread thread2 = new MyThread(Arrays.copyOfRange(array, array.length / 2, array.length), sum);
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("array = {1, 2, 3, 4, 5, 6, 7, 8}\nSum(array) = " + sum.getSum());
    }
}
