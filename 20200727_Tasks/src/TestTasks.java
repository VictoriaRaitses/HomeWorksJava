import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class TestTasks {
    @Test
    public void testReverseString() {
        Assert.assertEquals("olleH", Tasks.reverseString("Hello"));
    }


    @Test
    public void testChangeCase() {
        Assert.assertEquals("hEL-LO5", Tasks.changeСase("Hel-lo5"));
    }

    @Test
    public void testGetDuplicates() {
        Assert.assertEquals(Arrays.asList(1, 2), Tasks.getDuplicates(Arrays.asList(1, 2, 1, 8, -2, 2, 2)));
    }

    @Test
    public void testIsMultiplied() {
        Assert.assertTrue(Tasks.isMultiplied(Arrays.asList(1, 3, 8, 9, 11, 20), 33));

        Assert.assertFalse(Tasks.isMultiplied(Arrays.asList(1, 3, 8, 9, 11, 20), 161));

        Assert.assertFalse(Tasks.isMultiplied(Arrays.asList(1, 3, 8, 9, 11, 20), 64));

        Assert.assertTrue(Tasks.isMultiplied(Arrays.asList(1, 3, 8, 8, 11, 20), 64));
    }

    @Test
    public void testGCD() {
        Assert.assertEquals(5, Tasks.gcd(25, 5));

        Assert.assertEquals(-1, Tasks.gcd(25, 0));
    }

    @Test
    public void testSquareSum() {
        Assert.assertEquals(9, Tasks.getSquareSum(2, 1), 0);

        Assert.assertEquals(100, Tasks.getSquareSum(5, 5), 0);
    }
}
