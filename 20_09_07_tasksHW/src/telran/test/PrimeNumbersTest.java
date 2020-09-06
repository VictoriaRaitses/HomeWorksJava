package telran.test;

import org.junit.jupiter.api.Test;
import telran.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {
    PrimeNumbers primeNumbers = new PrimeNumbers();

    @Test
    public void testPrimeNumbers_zeroAndZero_emptyList() {
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, primeNumbers.primeSequence(0, 0));
    }

    @Test
    public void testPrimeNumbers_0and1_emptyList() {
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, primeNumbers.primeSequence(0, 1));
    }

    @Test
    public void testPrimeNumbers_0andNegativeNumber_emptyList() {
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, primeNumbers.primeSequence(0, -7));
    }

    @Test
    public void testPrimeNumbers_1and15() {
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13);
        assertEquals(expected, primeNumbers.primeSequence(1, 15));
    }

    @Test
    public void testPrimeNumbers_0andNegativeNumber_emptyList1() {
        List<Integer> expected = Arrays.asList(7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
                , 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        assertEquals(expected, primeNumbers.primeSequence(7, 101));
    }
}