package telran.test;

import org.junit.jupiter.api.Test;
import telran.PrimeNumbers;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {
    PrimeNumbers primeNumbers = new PrimeNumbers();

    @Test
    public void testIsPrime_zero_false() {
        assertFalse(primeNumbers.isPrime(0));
    }

    @Test
    public void testIsPrime_1_false() {
        assertFalse(primeNumbers.isPrime(1));
    }

    @Test
    public void testIsPrime_negativeNumber_false() {
        assertFalse(primeNumbers.isPrime(-7));
    }

    @Test
    public void testIsPrime_7_true() {
        assertTrue(primeNumbers.isPrime(7));
    }

    @Test
    public void testIsPrime_15_false() {
        assertFalse(primeNumbers.isPrime(15));
    }

    @Test
    public void testIsPrime_127_true() {
        assertTrue(primeNumbers.isPrime(127));
    }

    @Test
    public void testIsPrime_2393_true() {
        assertTrue(primeNumbers.isPrime(2393));
    }
}