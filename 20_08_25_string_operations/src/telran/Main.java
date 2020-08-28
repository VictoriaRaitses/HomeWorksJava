
package telran;

import telran.consumer.IStringOperation;
import telran.consumer.LineConsumer;
import telran.operation.LowerCase;
import telran.operation.Reverse;
import telran.operation.UpperCase;
import telran.properties.PropertiesLoader;
import telran.suplier.LineReader;
import telran.suplier.LineSupplier;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;;

public class Main {

    public static void main(String[] args) throws IOException {
        PropertiesLoader properties = new PropertiesLoader("config.properties");
        LineReader lineReader = new LineReader(properties.getProperty("path"));

        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        Map<String, IStringOperation> operationByName = new HashMap<>();
        operationByName.put(LowerCase.class.getName(), new LowerCase());
        operationByName.put(UpperCase.class.getName(), new UpperCase());
        operationByName.put(Reverse.class.getName(), new Reverse());

        Thread[] lineConsumers = new LineConsumer[5];
        Thread[] lineSuppliers = new LineSupplier[5];

        for (int i = 0; i < lineSuppliers.length; i++) {
            lineSuppliers[i] = new LineSupplier(queue, lineReader);
            lineSuppliers[i].start();
        }

        for (int i = 0; i < lineConsumers.length; i++) {
            lineConsumers[i] = new LineConsumer(queue, operationByName);
            lineConsumers[i].start();
        }
    }
}