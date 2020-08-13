package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurStackTest {
    Stack stack = new OurStack<Integer>(10);

    @Test
    public void testAddEltAndGetTop_getLastElt_8() {
        stack.addElement(3);
        stack.addElement(8);
        assertEquals(8, stack.getTop());
    }

    @Test
    public void testAddEltAndGetTop_add3elements_7() {
        stack.addElement(5);
        stack.addElement(2);
        stack.addElement(7);

        assertEquals(7, stack.getTop());
    }

    @Test
    public void testRemove_addEltAndRemoves_3() {
        stack.addElement(3);
        stack.addElement(5);
        assertEquals(5, stack.removeElement());
        assertEquals(3, stack.getTop());
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
    }

    @Test
    public void testIsEmpty_newInstance_true() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_addOneElt_false() {
        stack.addElement(2);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull_instance_true() {
        stack = new OurStack<Integer>(1);
        stack.addElement(5);

        assertTrue(stack.isFull());
    }

    @Test
    public void testIsFull_instance_False() {
        stack = new OurStack<Integer>(2);
        stack.addElement(5);

        assertFalse(stack.isFull());
    }

    @Test()
    public void testRemoveElt_removeFromEmptyStack_throwsOurStackEmptyException() {
        assertThrows(OurStackEmptyException.class, () -> stack.removeElement());
    }

    @Test()
    public void testAddElt_zeroCapacityAndAddToFullStack_throwsOurStackOverflowException() {
        stack = new OurStack(0);
        assertThrows(OurStackOverflowException.class, () -> stack.addElement(5));
    }

    @Test
    public void testGetMaxElement_add3El_9() {

        stack.addElement(9);
        stack.addElement(2);
        stack.addElement(7);

        assertEquals(9, stack.getMaxValue());

    }


    @Test
    public void testGetMaxElement_emptyStack_throwsOurStackEmptyException() {

        stack = new OurStack<Integer>(1);
        assertThrows(OurStackEmptyException.class, () -> stack.getMaxValue());

    }

}