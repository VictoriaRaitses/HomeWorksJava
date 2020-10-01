package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoTest {
    Casino casino = new Casino();


    @Test
    public void testStepsToWin_1Winning_0() {
        assertEquals(0, casino.stepsToWin(1, 1));
    }

    @Test
    public void testStepsToWin_2Winning() {
        assertEquals(1, casino.stepsToWin(2, 0));
    }

    @Test
    public void testStepsToWin_2Winning_1() {
        assertEquals(1, casino.stepsToWin(2, 2));
    }

    @Test
    public void testStepsToWin_9Winning_4() {
        assertEquals(4, casino.stepsToWin(9, 2));
    }

    @Test
    public void testStepsToWin_12Winning_6() {
        assertEquals(6, casino.stepsToWin(12, 1));
    }

    @Test
    public void testStepsToWin_51Winning_8() {
        assertEquals(8, casino.stepsToWin(51, 9));
    }

    @Test
    public void testStepsToWin_31Winning_8() {
        assertEquals(8, casino.stepsToWin(31, 3));
    }

    @Test
    public void testStepsToWin_73Winning_20() {
        assertEquals(20, casino.stepsToWin(73, 2));
    }
}