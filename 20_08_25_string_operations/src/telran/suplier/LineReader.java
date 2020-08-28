package telran.suplier;

import java.io.*;

public class LineReader {

    private BufferedReader reader;

    public LineReader(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        reader = new BufferedReader(new FileReader(file));

    }

    synchronized String getLine() throws IOException {
        String line = reader.readLine();
        if (line != null) {
            System.out.println(":getLine: id:" + Thread.currentThread().getId() + " :" + line);
            return line;
        }
        reader.close();
        return null;
    }

}
