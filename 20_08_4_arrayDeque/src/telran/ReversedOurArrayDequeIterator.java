package telran;

import java.util.Iterator;

public class ReversedOurArrayDequeIterator<T> implements Iterator<T> {

    OurArrayDeque<T> toIterate;
    int currentIndexNumber;

    public ReversedOurArrayDequeIterator(OurArrayDeque<T> toIterate) {
        this.toIterate = toIterate;
        currentIndexNumber = toIterate.size - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndexNumber >= 0;
    }

    @Override
    public T next() {
        int indexInSourceToReturn = (toIterate.firstEltIndex + currentIndexNumber) % toIterate.capacity;
        currentIndexNumber--;
        return (T) toIterate.source[indexInSourceToReturn];

    }

}