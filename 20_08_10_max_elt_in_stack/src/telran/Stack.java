package telran;

import java.util.Iterator;

public interface Stack {
    public void addElement(int element);

    public int removeElement();

    public int getTop();

    public int getMaxValue();

    public int getSize();
}