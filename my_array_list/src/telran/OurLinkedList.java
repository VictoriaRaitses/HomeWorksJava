package telran;

import java.util.*;

public class OurLinkedList<T> implements OurList<T> {

    private int size;
    Node<T> first;
    Node<T> last;

    @Override
    public void add(T elt) {
        Node<T> newNode = new Node<>(elt, null, last);

        if (size == 0) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node node = getNode(index);
        node.elt = elt;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (T) getNode(index).elt;
    }

    public Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean contains(T elt) {
        Node node = first;
        for (int i = 0; i < size - 1; i++) {
            node = node.next;
            if (node.elt.equals(elt))
                return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node removedNode = getNode(index);

        if (index == 0) {
            first = removedNode.next;
            first.prev = null;
        } else if (index == size - 1) {
            last = removedNode.prev;
            last.next = null;
        } else {
            removedNode.prev.next = removedNode.next;
            removedNode.next.prev = removedNode.prev;
        }
        size--;
        return (T) removedNode.elt;
    }

    @Override
    public boolean remove(T elt) {
        if (size == 0)
            throw new IndexOutOfBoundsException();

        for (int i = 0; i < size; i++) {
            Node removedNode = getNode(i);
            if (elt.equals(removedNode.elt)) {
                remove(i);

                if (removedNode.prev == null) {
                    first = removedNode.next;
                    first.prev = null;
                } else if (removedNode.next == null) {
                    last = removedNode.prev;
                    last.next = null;
                } else {
                    removedNode.prev.next = removedNode.next;
                    removedNode.next.next = removedNode.prev;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> currentNode = null;

            @Override
            public boolean hasNext() {
                return currentNode != last;
            }

            @Override
            public T next() {
                if (currentNode == null) {
                    currentNode = first;
                    return currentNode.elt;
                }
                currentNode = currentNode.next;
                return currentNode.elt;
            }

        };
    }

    static class Node<T> implements Comparable<T> {

        public Node(T elt, Node<T> next, Node<T> prev) {
            this.elt = elt;
            this.next = next;
            this.prev = prev;
        }

        T elt;
        Node<T> next;
        Node<T> prev;

        @Override
        public int compareTo(T o) {
            return this.compareTo(o);
        }
    }
}