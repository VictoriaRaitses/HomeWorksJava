package telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {
    OurArrayList ourArrayList = new OurArrayList<Integer>();

    @Test
    public void testSize_emptyList_0() {
        assertEquals(0, ourArrayList.size);
    }

    @Test
    public void testAddEltAndSize_1elt_1() {
        ourArrayList.add(6);
        assertEquals(1, ourArrayList.size);
    }

    @Test
    public void testSize_add7elt_3() {
        ourArrayList.add(7);
        ourArrayList.add(7);
        ourArrayList.add(7);

        assertEquals(3, ourArrayList.size);
    }

    @Test
    void testGetElt_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourArrayList.get(0));
    }

    @Test
    void testSetAndGetElt_addOneElt_10() {
        ourArrayList.add(9);
        ourArrayList.set(0, 10);
        assertEquals(10, ourArrayList.get(0));
    }

    @Test
    void testGetElt_add5Elt_7() {
        ourArrayList.add(9);
        ourArrayList.add(8);
        ourArrayList.add(9);
        ourArrayList.add(6);
        ourArrayList.add(5);
        ourArrayList.set(2, 7);
        assertEquals(7, ourArrayList.get(2));
    }

    @Test
    void testComtainsElt_add6Elt_true() {
        ourArrayList.add(10);
        ourArrayList.add(8);
        ourArrayList.add(9);
        ourArrayList.add(6);
        ourArrayList.add(5);
        ourArrayList.add(2);
        assertTrue(ourArrayList.contains(9));
    }

    @Test
    void testComtainsElt_add6Elt_false() {
        ourArrayList.add(9);
        ourArrayList.add(8);
        ourArrayList.add(9);
        ourArrayList.add(6);
        ourArrayList.add(5);
        ourArrayList.add(2);
        assertFalse(ourArrayList.contains(1));
    }

    @Test
    void testRemoveEltByIndex_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourArrayList.remove(0));
    }

    @Test
    public void testRemoveEltByIndex_addOneElt_56() {
        ourArrayList.add(56);
        assertEquals(56, ourArrayList.remove(0));
    }

    @Test
    void testRemoveEltByIndex_add6Elt_99() {
        ourArrayList.add(99);
        ourArrayList.add(87);
        ourArrayList.add(9);
        ourArrayList.add(66);
        ourArrayList.add(99);
        ourArrayList.add(20);
        assertEquals(99, ourArrayList.remove(4));
    }

    @Test
    void testRemoveByElt_emptyList_False() {
        assertFalse(ourArrayList.remove((Integer) 7));
    }

    @Test
    public void testRemoveByElt_addOneElt_true() {
        ourArrayList.add(56);
        assertTrue(ourArrayList.remove((Integer) 56));
    }

    @Test
    public void testRemoveByElt_addOneElt_false() {
        ourArrayList.add(56);
        assertFalse(ourArrayList.remove((Integer) 57));
    }

    @Test
    void testRemoveByElt_add6Elt_true() {
        ourArrayList.add(99);
        ourArrayList.add(87);
        ourArrayList.add(9);
        ourArrayList.add(66);
        ourArrayList.add(99);
        ourArrayList.add(20);
        assertTrue(ourArrayList.remove((Integer) 66));
    }

    @Test
    void testRemoveByElt_add6Elt_false() {
        ourArrayList.add(99);
        ourArrayList.add(87);
        ourArrayList.add(9);
        ourArrayList.add(66);
        ourArrayList.add(99);
        ourArrayList.add(20);
        assertFalse(ourArrayList.remove((Integer) 100));
    }

    @Test
    public void testIterator() {

        ourArrayList.add(6);
        ourArrayList.add(0);
        ourArrayList.add(43);
        ourArrayList.add(809);
        ourArrayList.add(23);
        ourArrayList.add(777);

        Iterator<Integer> it = ourArrayList.iterator();

        OurArrayList<Integer> result = new OurArrayList<>();
        while (it.hasNext()) {
            int current = it.next();
            result.add(current);
        }

        OurArrayList<Integer> expected = new OurArrayList<>();
        expected.add(6);
        expected.add(0);
        expected.add(43);
        expected.add(809);
        expected.add(23);
        expected.add(777);
        assertEquals(expected, result);
    }

}