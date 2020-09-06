package telran;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

    public List<Integer> primeSequence(int min, int max) {
        return IntStream.range(min, max)
                .filter(PrimeNumbers::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }
}
