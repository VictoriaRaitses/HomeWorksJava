package telran;

import java.util.stream.IntStream;

public class OddNumbersSum {

    public int getSum(int a, int b) {
        int result = IntStream.range(a, b)
                .filter(n -> n % 2 != 0)
                .boxed()
                .reduce(0, (subtotal, element) -> subtotal + element);
        return result;
    }
}
