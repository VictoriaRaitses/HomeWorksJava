package telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Create 3 same consumers and one supplier, make consumers daemon.
        System.out.println("Starting main id:" + Thread.currentThread().getId());
        OneElementBlockingQueue oneElementBlockingQueue = new OneElementBlockingQueue();
        StringSupplier ss1 = new StringSupplier(oneElementBlockingQueue);
        StringConsumer sc1 = new StringConsumer(oneElementBlockingQueue);
        StringConsumer sc2 = new StringConsumer(oneElementBlockingQueue);
        StringConsumer sc3 = new StringConsumer(oneElementBlockingQueue);

        sc1.setDaemon(true);
        sc2.setDaemon(true);
        sc3.setDaemon(true);

        sc1.start();
        sc2.start();
        sc3.start();
        ss1.start();
    }
}