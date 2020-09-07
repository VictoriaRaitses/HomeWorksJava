package telran;

import java.util.stream.IntStream;

public class PrimeNumbers {

    public boolean isPrime(int number) {
        if (number < 2) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}
