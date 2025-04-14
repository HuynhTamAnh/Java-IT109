package bt7;

public class FibonacciConsumer implements Runnable {
    private final SharedData sharedData;
    private int count = 0;

    public FibonacciConsumer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            while (count < 10) {
                int value = sharedData.get();
                System.out.println("Fibonacci number " + (count + 1) + ": " + value);
                count++;
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
