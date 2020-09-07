package telran;

import java.util.stream.IntStream;

public class Factorial {

    public int getFactorial(int f) {

        return IntStream.rangeClosed(2, f).reduce(1, (x, y) -> x * y);
    }
}
