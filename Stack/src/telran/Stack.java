package telran;

import java.util.Iterator;

public interface Stack<T extends Comparable<T>> extends Iterable<T> {
    public void addElement(T element);

    public T removeElement();

    public T getTop();

    public boolean isEmpty();

    public boolean isFull();

    public T getMaxValue();
}
