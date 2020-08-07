package telran;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    T[] array;
    int currentIndex;

    ArrayIterator(T[] array) {
        this.array = array;
        currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        T res = array[currentIndex];
        currentIndex++;
        return res;
    }
}
