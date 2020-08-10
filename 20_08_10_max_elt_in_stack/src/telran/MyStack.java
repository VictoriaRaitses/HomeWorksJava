package telran;

import java.util.*;

public class MyStack implements Stack {

    private Deque<Integer> stackArray;
    private Deque<Integer> maxEltStack;
    private int size;

    public MyStack() {
        stackArray = new ArrayDeque<>();
        maxEltStack = new ArrayDeque<>();
        size = 0;
    }

    @Override
    public void addElement(int element) {
        if (size == 0 || maxEltStack.getLast() < element) {
            maxEltStack.addLast(element);
        } else {
            maxEltStack.addLast(maxEltStack.getLast());
        }
        stackArray.addLast(element);
        size++;
    }

    @Override
    public int removeElement() {
        if (size == 0)
            throw new OurStackEmptyException();
        maxEltStack.removeLast();
        size--;
        return stackArray.removeLast();
    }

    @Override
    public int getTop() {
        if (size == 0)
            throw new OurStackEmptyException();
        return stackArray.getLast();
    }

    @Override
    public int getMaxValue() {
        if (size == 0)
            throw new OurStackEmptyException();
        return maxEltStack.getLast();
    }

    @Override
    public int getSize() {
        return size;
    }
}