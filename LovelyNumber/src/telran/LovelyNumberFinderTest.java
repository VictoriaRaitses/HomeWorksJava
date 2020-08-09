package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LovelyNumberFinderTest {

    LovelyNumberFinder lovelyNumberFinder = new LovelyNumberFinder();

    @Test
    public void testLovelyNumber_0_true() {
        assertTrue(lovelyNumberFinder.isLovelyNumber(0));
    }

    @Test
    public void testLovelyNumber_1234_true() {
        assertTrue(lovelyNumberFinder.isLovelyNumber(1234));
    }

    @Test
    public void testLovelyNumber_12234_true() {
        assertTrue(lovelyNumberFinder.isLovelyNumber(12234));
    }

    @Test
    public void testLovelyNumber_122234_false() {
        assertFalse(lovelyNumberFinder.isLovelyNumber(122234));
    }

    @Test
    public void testLovelyNumber_1234444_false() {
        assertFalse(lovelyNumberFinder.isLovelyNumber(1234444));
    }

}