package telran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSupplier extends Thread {
    private final OneElementBlockingQueue queue;

    public StringSupplier(OneElementBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //Must accept lines from System.in and put them into the queue. See Echo Messenger project
        System.out.println("Starting Supplier id:" + Thread.currentThread().getId());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {
            try {
                System.out.println("Supplier id:" + Thread.currentThread().getId() + " please write a line");
                if (!((line = br.readLine()) != null && !line.equals("exit"))) break;
                queue.addFirst(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //lp.setLine("Print: " + line);
            //lp.interrupt();
        }
        try {
            queue.addFirst(line);
            System.out.println("bye-bye Supplier thread id:" + Thread.currentThread().getId());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}