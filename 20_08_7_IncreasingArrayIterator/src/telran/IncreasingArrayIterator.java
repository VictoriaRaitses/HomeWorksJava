package telran;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class IncreasingArrayIterator<Integer> implements Iterator<Integer> {
    /**
     * a copy of the array which needs to be iterated for.
     */
    Integer[] array;
    int currentIndex;

    IncreasingArrayIterator(Integer[] array) {
        this.array = array;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public Integer next() {
        Integer[] arrayCopy = array.clone();
        Arrays.sort(arrayCopy);
        Integer res = arrayCopy[currentIndex];
        currentIndex++;
        return res;
    }
}
