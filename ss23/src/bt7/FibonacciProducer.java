package bt7;

public class FibonacciProducer implements Runnable {
    private final SharedData sharedData;
    private int count = 0;
    private int a = 0, b = 1;

    public FibonacciProducer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            while (count < 10) {
                int nextValue = (count == 0) ? 0 : (count == 1) ? 1 : a + b;
                sharedData.put(nextValue);

                if (count >= 1) {
                    int temp = a + b;
                    a = b;
                    b = temp;
                }
                count++;
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}