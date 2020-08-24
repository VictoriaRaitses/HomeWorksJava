package telran;

public class StringConsumer extends Thread {

    private final OneElementBlockingQueue queue;

    public StringConsumer(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Starting Consumer  id:" + Thread.currentThread().getId());
        while (true) {
            try {
                System.out.println("Consumer id:" + Thread.currentThread().getId() + " going to fetch");
                String line = queue.removeLast();
                System.out.println(line + " " + this.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}