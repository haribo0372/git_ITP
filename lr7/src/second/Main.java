package second;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();
    }
}
