package telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {
    @Test
    public void testArrayIterator() {
        Integer[] array = new Integer[]{3, -5, 1};
        List<Integer> expected = Arrays.asList(3, -5, 1);
        List<Integer> afterIteration = new ArrayList<>();

        ArrayIterator<Integer> it = new ArrayIterator<>(array);
        while (it.hasNext()) {
            int num = it.next();
            afterIteration.add(num);
        }

        assertEquals(expected, afterIteration);
    }
}