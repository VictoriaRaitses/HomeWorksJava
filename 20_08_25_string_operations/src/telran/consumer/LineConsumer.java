package telran.consumer;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class LineConsumer extends Thread {

    BlockingQueue<String> queue;
    Map<String, IStringOperation> operationByName;

    public LineConsumer(BlockingQueue<String> queue, Map<String, IStringOperation> operationByName) {
        this.queue = queue;
        this.operationByName = operationByName;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Starting LineConsumer id:" + Thread.currentThread().getId());
            String line = queue.poll();
            if (line == null) {
                System.out.println("Bye-Bye");
                return;
            }
            System.out.println("LineConsumer id:" + Thread.currentThread().getId() + " : " + line);

            String[] splitLine = line.split("#");
            String text = splitLine[0];
            String operationName = splitLine[1];

            if (operationByName.containsKey(operationName)) {
                IStringOperation operation = operationByName.get(operationName);
                String res = operation.operate(text);
                System.out.println("LineConsumer id:" + Thread.currentThread().getId() + " : " + res);
            } else {
                System.out.println("operation not supported: " + line);
            }
        }
    }
}