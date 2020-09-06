package telran.test;

import org.junit.jupiter.api.Test;
import telran.Factorial;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    Factorial factorial = new Factorial();

    @Test
    public void testFactorial_zero_one() {
        assertEquals(1, factorial.getFactorial(0));
    }

    @Test
    public void testFactorial_one_one() {
        assertEquals(1, factorial.getFactorial(1));
    }

    @Test
    public void testFactorial_6_720() {
        assertEquals(720, factorial.getFactorial(6));
    }

    @Test
    public void testFactorial_10_3628800() {
        assertEquals(3_628_800, factorial.getFactorial(10));
    }

}