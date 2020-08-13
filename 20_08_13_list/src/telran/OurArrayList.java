package telran;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * An implementation of the List data structure, made via array under the hood.
 * The initial array has length 16. In the case the array is full, a new
 * array with the capacity of 2*<old length> must be created as a new
 * source for the elements.
 *
 * @param <T>
 */
public class OurArrayList<T> implements OurList<T> {

    Object[] source;
    int size;
    final int DEFAULT_CAPACITY = 16;

    public OurArrayList() {
        source = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T elt) {
        if (size == source.length) {
            Object[] newSource = new Object[size + DEFAULT_CAPACITY];
            System.arraycopy(source, 0, newSource, 0, source.length);
            source = newSource;
        }
        source[size++] = elt;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else source[index] = elt;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) source[index];
    }

    @Override
    public boolean contains(T elt) {
        for (int i = 0; i < size; i++) {
            if (source[i] == elt)
                return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object result = (T) source[index];
        System.arraycopy(source, index + 1, source, index, size - index - 1);
        size--;
        return (T) result;
    }

    @Override
    public boolean remove(T elt) {
        for (int i = 0; i < size; i++) {
            if (source[i].equals(elt)) {
                System.arraycopy(source, i + 1, source, i, size - (i - 1));
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void sort() {
        Arrays.sort((T[]) source, 0, size);
    }

    @Override
    public void sort(Comparator<T> comparator) {

        Arrays.sort((T[]) source, 0, size, comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentNumber;

            @Override
            public boolean hasNext() {
                return currentNumber < size;
            }

            @Override
            public T next() {
                return (T) source[currentNumber++];
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OurArrayList)) return false;
        OurArrayList<?> that = (OurArrayList<?>) o;
        return size == that.size &&
                DEFAULT_CAPACITY == that.DEFAULT_CAPACITY &&
                Arrays.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, DEFAULT_CAPACITY);
        result = 31 * result + Arrays.hashCode(source);
        return result;
    }

}