package telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingArrayIteratorTest {

    @Test
    public void testArrayIterator() {
        Integer[] array = new Integer[]{3, -5, 1};
        List<Integer> expected = Arrays.asList(-5, 1, 3);
        List<Integer> afterIteration = new ArrayList<>();

        IncreasingArrayIterator<Integer> it = new IncreasingArrayIterator<>(array);
        while (it.hasNext()) {
            int num = it.next();
            afterIteration.add(num);
        }

        assertEquals(expected, afterIteration);
    }
}