public class ArrayAverage {
    public static void example(String[] arg, int len) {
        int sum = 0;
        try {
            for (int i = 0; i < len; i++) {
                sum += Integer.parseInt(arg[i]);
            }
            double average = (double) sum /len;
            System.out.println("Average = " + average);
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException aioo) {
            System.out.println("Error: " + aioo);
        }
    }
}
