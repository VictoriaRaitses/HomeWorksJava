package telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurLinkedListTest {
    OurLinkedList ourLinkedList;

    @BeforeEach
    public void init() {
        ourLinkedList = new OurLinkedList<Integer>();
    }

    @Test
    public void testSize_emptyList_0() {
        assertEquals(0, ourLinkedList.size());
    }

    @Test
    public void testAddEltAndSize_1elt_1() {
        ourLinkedList.add(6);
        assertEquals(1, ourLinkedList.size());
    }

    @Test
    public void testSize_add7elt_3() {
        ourLinkedList.add(7);
        ourLinkedList.add(7);
        ourLinkedList.add(7);

        assertEquals(3, ourLinkedList.size());
    }

    @Test
    public void testSize_add17elt_17() {
        for (int i = 0; i < 18; i++) {
            ourLinkedList.add(i);
        }

        assertEquals(18, ourLinkedList.size());
    }

    @Test
    void testGetElt_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourLinkedList.get(0));
    }

    @Test
    void testSetAndGetElt_addOneElt_10() {
        ourLinkedList.add(9);
        ourLinkedList.set(0, 10);
        assertEquals(10, ourLinkedList.get(0));
    }

    @Test
    void testGetElt_add5Elt_7() {
        ourLinkedList.add(9);
        ourLinkedList.add(8);
        ourLinkedList.add(9);
        ourLinkedList.add(6);
        ourLinkedList.add(5);
        ourLinkedList.set(2, 7);
        assertEquals(7, ourLinkedList.get(2));
    }

    @Test
    void testGetElt_add5EltAndGetLast_5() {
        ourLinkedList.add(9);
        ourLinkedList.add(8);
        ourLinkedList.add(9);
        ourLinkedList.add(6);
        ourLinkedList.add(5);
        assertEquals(5, ourLinkedList.get(4));
    }

    @Test
    void testContainsElt_add6Elt_true() {
        ourLinkedList.add(10);
        ourLinkedList.add(8);
        ourLinkedList.add(9);
        ourLinkedList.add(6);
        ourLinkedList.add(5);
        ourLinkedList.add(2);
        assertTrue(ourLinkedList.contains(9));
    }

    @Test
    void testContainsElt_add6Elt_false() {
        ourLinkedList.add(9);
        ourLinkedList.add(8);
        ourLinkedList.add(9);
        ourLinkedList.add(6);
        ourLinkedList.add(5);
        ourLinkedList.add(2);
        assertFalse(ourLinkedList.contains(1));
    }

    @Test
    public void testRemoveEltByIndex_addOneElt_56() {
        ourLinkedList.add(56);
        assertEquals(56, ourLinkedList.remove(0));
    }


    @Test
    public void testRemoveEltByIndexAndSize_3Elt_0() {
        ourLinkedList.add(56);
        ourLinkedList.add(57);
        ourLinkedList.add(58);
        assertEquals(56, ourLinkedList.remove(0));
        assertEquals(57, ourLinkedList.remove(0));
        assertEquals(58, ourLinkedList.remove(0));
        assertEquals(0, ourLinkedList.size());
    }

    @Test
    void testRemoveEltByIndex_add6Elt_99() {
        ourLinkedList.add(99);
        ourLinkedList.add(87);
        ourLinkedList.add(9);
        ourLinkedList.add(66);
        ourLinkedList.add(99);
        ourLinkedList.add(20);
        assertEquals(99, ourLinkedList.remove(4));
    }

    @Test
    void testRemoveEltByIndex_add3EltAndRemoveFirst_99() {
        ourLinkedList.add(99);
        ourLinkedList.add(87);
        ourLinkedList.add(9);

        assertEquals(99, ourLinkedList.remove(0));
    }

    @Test
    void testRemoveEltByIndex_getLast_8() {
        ourLinkedList.add(10);
        ourLinkedList.add(8);
        ourLinkedList.add(9);
        ourLinkedList.remove(1);
        assertEquals(9, ourLinkedList.get(1));
    }

    @Test
    void test_remove_elt_by_index_add_3EltAndRemoveLast_9() {
        ourLinkedList.add(99);
        ourLinkedList.add(87);
        ourLinkedList.add(9);

        assertEquals(9, ourLinkedList.remove(2));
        ourLinkedList.add(9);
        assertEquals(87, ourLinkedList.remove(1));

    }

    @Test
    void testRemoveByIndex_removeAndGetFirst_null() {
        ourLinkedList.add(9);
        ourLinkedList.add(8);
        ourLinkedList.add(7);
        ourLinkedList.remove(0);

        assertEquals(null, ourLinkedList.getNode(0).prev);
    }

    @Test
    void testRemoveByIndex_removeAndGetLast_null() {
        ourLinkedList.add(9);
        ourLinkedList.add(8);
        ourLinkedList.add(7);
        ourLinkedList.remove(2);

        assertEquals(null, ourLinkedList.getNode(1).next);
    }

    @Test
    void testRemoveByElt_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourLinkedList.remove((Integer) 9));
    }

    @Test
    public void testRemoveByElt_addOneElt_true() {
        ourLinkedList.add(56);
        assertTrue(ourLinkedList.remove((Integer) 56));
    }

    @Test
    public void testRemoveByElt_addOneElt_false() {
        ourLinkedList.add(56);
        assertFalse(ourLinkedList.remove((Integer) 57));
    }

    @Test
    void testRemoveByElt_add6Elt_true() {
        ourLinkedList.add(99);
        ourLinkedList.add(87);
        ourLinkedList.add(9);
        ourLinkedList.add(66);
        ourLinkedList.add(99);
        ourLinkedList.add(20);
        assertTrue(ourLinkedList.remove((Integer) 66));
    }

    @Test
    void testRemoveByElt_add6Elt_false() {
        ourLinkedList.add(99);
        ourLinkedList.add(87);
        ourLinkedList.add(9);
        ourLinkedList.add(66);
        ourLinkedList.add(99);
        ourLinkedList.add(20);
        assertFalse(ourLinkedList.remove((Integer) 100));
    }

//    @Test
//    public void testDefaultSort_add16elt_7() {
//        for (int i = 17; i > 0; i--) {
//            ourLinkedList.add(i);
//        }
//
//        ourLinkedList.sort();
//        assertEquals(7, ourLinkedList.get(6));
//    }

//    @Test
//    public void testSortWithAnotherComparator_add16elt_4() {
//        OurComparator comparator = new OurComparator();
//        for (int i = 17; i > 0; i--) {
//            ourLinkedList.add(i);
//        }
//
//        ourLinkedList.sort(comparator);
//        assertEquals(5, ourLinkedList.get(4));
//    }

    @Test
    public void testArrayIterator() {

        ourLinkedList.add(2);
        ourLinkedList.add(-1);
        ourLinkedList.add(23);
        ourLinkedList.add(4);
        ourLinkedList.add(89);

        OurList<Integer> afterIteration = new OurLinkedList<>();

        OurList<Integer> expected = new OurLinkedList<>();
        expected.add(2);
        expected.add(-1);
        expected.add(23);
        expected.add(4);
        expected.add(89);

        Iterator<Integer> it = ourLinkedList.iterator();
        while (it.hasNext()) {
            int num = it.next();
            afterIteration.add(num);
        }

        for (int i = 0; i < ourLinkedList.size(); i++) {
            assertEquals(expected.get(i), afterIteration.get(i));
        }
    }

}