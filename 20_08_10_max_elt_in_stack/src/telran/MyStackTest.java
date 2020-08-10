package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurStackTest {
    Stack stack = new MyStack();

    @Test
    public void testGetSize_emptyStack_0() {
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testGetSizeAndAddElement_add1elt_1() {
        stack.addElement(5);
        assertEquals(1, stack.getSize());
    }

    @Test
    public void testGetSizeAndAddElement_add5elements_5() {
        stack.addElement(5);
        stack.addElement(-9);
        stack.addElement(0);
        stack.addElement(7);
        stack.addElement(-3);
        assertEquals(5, stack.getSize());
    }

    @Test
    public void testRemoveElement_emptyStack_throwsOurStackEmptyException() {
        assertThrows(OurStackEmptyException.class, () -> stack.removeElement());
    }

    @Test
    public void testRemoveElement_add1EltAndRemove_5() {
        stack.addElement(5);
        assertEquals(5, stack.removeElement());
    }

    @Test
    public void testGetTop_emptyStack_throwsOurStackEmptyException() {
        assertThrows(OurStackEmptyException.class, () -> stack.getTop());
    }

    @Test
    public void testGetTop_add1Elt_98() {
        stack.addElement(98);
        assertEquals(98, stack.getTop());
    }

    @Test
    public void testGetTop_add4Elements_10() {
        stack.addElement(98);
        stack.addElement(9);
        stack.addElement(8);
        stack.addElement(10);
        assertEquals(10, stack.getTop());
    }

    @Test
    public void testGetMaxValue_emptyStack_throwsOurStackEmptyException() {
        assertThrows(OurStackEmptyException.class, () -> stack.getMaxValue());
    }

    @Test
    public void testGetMaxValue_add1Elt_4() {
        stack.addElement(4);
        assertEquals(4, stack.getMaxValue());
    }

    @Test
    public void testGetMaxValue_add4Elements_98() {
        stack.addElement(98);
        stack.addElement(9);
        stack.addElement(8);
        stack.addElement(10);
        assertEquals(98, stack.getMaxValue());
    }

    @Test
    public void testGetMaxValue_add2RepeatingElements_100() {
        stack.addElement(98);
        stack.addElement(100);
        stack.addElement(8);
        stack.addElement(100);
        stack.addElement(10);
        assertEquals(100, stack.getMaxValue());
    }

    @Test
    public void testGetMaxValue_add3RepeatingElements_101() {
        stack.addElement(101);
        stack.addElement(101);
        stack.addElement(98);
        stack.addElement(101);
        stack.addElement(98);
        assertEquals(101, stack.getMaxValue());
    }

    @Test
    public void testAddRemoveMix_severalElementsAdded_removeSeveralElements() {
        stack.addElement(3);
        stack.addElement(8);
        assertEquals(8, stack.removeElement());
        stack.addElement(-5);
        stack.addElement(-2);
        stack.addElement(7);
        stack.addElement(10);
        assertEquals(10, stack.removeElement());
        stack.addElement(13);
        assertEquals(13, stack.getTop());
        assertEquals(5, stack.getSize());
    }
}