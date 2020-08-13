package telran;

import java.util.*;

public class OurStack<T extends Comparable<T>> implements Stack<T> {

    private int capacity;
    private Object[] stackArray;
    private int top;

    public OurStack(int capacity) {
        this.capacity = capacity;
        stackArray = new Object[capacity];
        top = 0;
    }

    @Override
    public void addElement(T element) {
        if (isFull())
            throw new OurStackOverflowException();
        stackArray[top++] = element;

    }

    @Override
    public T removeElement() {
        if (isEmpty())
            throw new OurStackEmptyException();
        return (T) stackArray[--top];
    }

    @Override
    public T getTop() {
        if (isEmpty())
            throw new OurStackEmptyException();
        return (T) stackArray[top - 1];
    }

    @Override
    public T getMaxValue() {
        if (isEmpty())
            throw new OurStackEmptyException();
        Iterator<T> it = iterator();
        T max = (T) stackArray[0];
        while (it.hasNext()) {
            T next = it.next();
            if (next.compareTo(max) > 0)
                max = next;
        }
        return max;
    }

    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    @Override
    public boolean isFull() {
        return (top == capacity);
    }


    @Override
    public Iterator<T> iterator() {
        return new DefaultIterator();
    }


    public class DefaultIterator implements Iterator<T> {

        /**
         * the number of the current element from 0 to (size-1)
         */
        int currentIndexNumber;

        @Override
        public boolean hasNext() {
            return currentIndexNumber < top;
        }

        @Override
        public T next() {
            return (T) stackArray[currentIndexNumber++];
        }
    }
}