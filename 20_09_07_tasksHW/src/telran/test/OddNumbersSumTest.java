package telran.test;

import org.junit.jupiter.api.Test;
import telran.OddNumbersSum;

import static org.junit.jupiter.api.Assertions.*;

class OddNumbersSumTest {
    OddNumbersSum oddNumbersSum = new OddNumbersSum();

    @Test
    public void testGetSum() {
        assertEquals(0, oddNumbersSum.getSum(0, 0));
    }

    @Test
    public void testGetSum_zeroAndNegativeNumber() {
        assertEquals(-16, oddNumbersSum.getSum(-7, 0));
    }

    @Test
    public void testGetSum_0and6_9() {
        assertEquals(9, oddNumbersSum.getSum(0, 6));
    }

    @Test
    public void testGetSum_1and15_49() {
        assertEquals(49, oddNumbersSum.getSum(1, 15));
    }
}