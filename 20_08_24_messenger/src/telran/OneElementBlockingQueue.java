package telran;

public class OneElementBlockingQueue {

    final Object readerMutex = new Object();

    volatile String element;

    public String removeLast() throws InterruptedException {
        synchronized (readerMutex) {
            System.out.println(":removeLast: Consumer id:" + Thread.currentThread().getId());
            while (element == null)
                readerMutex.wait();

            String res = element;
            element = null;
            System.out.println("removeLast: Consumer id: " + Thread.currentThread().getId() + " received : " + res);

            return res;
        }
    }

    public void addFirst(String line) {
        System.out.println(":addFirst: Supplier id:" + Thread.currentThread().getId() + " : " + line);
        synchronized (readerMutex) {
            element = line;
            readerMutex.notify();
        }
    }
}