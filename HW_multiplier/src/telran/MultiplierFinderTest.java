package telran;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MultiplierFinderTest {
    MultiplierFinder multiplierFinder = new MultiplierFinder();
    LinkedList<Integer> list = new LinkedList<>();

    {
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(9);
        list.add(11);
        list.add(20);
    }

    @Test
    public void testIsMultiplied_0_false() {
        assertFalse(multiplierFinder.isMultiplied(list, 0));
    }

    @Test
    public void testIsMultiplied_0_true() {
        list.add(0);
        assertTrue(multiplierFinder.isMultiplied(list, 0));
    }

    @Test
    public void testIsMultiplied_1_false() {
        assertFalse(multiplierFinder.isMultiplied(list, 1));
    }

    @Test
    public void testIsMultiplied_1_true() {
        list.add(1);
        assertTrue(multiplierFinder.isMultiplied(list, 1));
    }

    @Test
    public void testIsMultiplied_33_true() {
        assertTrue(multiplierFinder.isMultiplied(list, 33));
    }

    @Test
    public void testIsMultiplied_161_false() {
        assertFalse(multiplierFinder.isMultiplied(list, 161));
    }

    @Test
    public void testIsMultiplied_64_false() {
        assertFalse(multiplierFinder.isMultiplied(list, 64));
    }

    @Test
    public void testIsMultiplied_64_withTwoEights_true() {
        list.add(8);
        assertTrue(multiplierFinder.isMultiplied(list, 64));
    }

    @Test
    public void testIsMultiplied_64_withThreeEights_true() {
        list.add(8);
        list.add(8);
        assertTrue(multiplierFinder.isMultiplied(list, 64));
    }
}