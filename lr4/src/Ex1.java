public class Ex1 {
    public static void main(String[] args) {
        String[] a1 = { "1", "2", "3", "4", "5" },
                a2 = { "1", "2", "null", "4", "5" };
        ArrayAverage.example(a1, 5);
        ArrayAverage.example(a1, 6);
        ArrayAverage.example(a2, 5);
    }
}
