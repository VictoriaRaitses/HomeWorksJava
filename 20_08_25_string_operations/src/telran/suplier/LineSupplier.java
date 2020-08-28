package telran.suplier;

import java.util.concurrent.BlockingQueue;

public class LineSupplier extends Thread {

    private final BlockingQueue<String> queue;
    private final LineReader lineReader;

    public LineSupplier(BlockingQueue<String> queue, LineReader lineReader) {
        this.queue = queue;
        this.lineReader = lineReader;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting LineSupplier id:" + Thread.currentThread().getId());
            String line = lineReader.getLine();
            if (line == null)
                return;
            queue.add(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
