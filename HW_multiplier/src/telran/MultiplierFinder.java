package telran;

import java.util.LinkedList;

public class MultiplierFinder {

    public boolean isMultiplied(LinkedList<Integer> list, int num) {
        Integer first = list.getFirst();
        Integer last = list.getLast();

        while (list.size() > 1) {
            if (first * last == num) {
                return true;
            }
            if (first * last > num) {
                list.removeLast();
                last = list.getLast();

            }
            if (first * last < num) {
                list.removeFirst();
                first = list.getFirst();
            }
        }
        return false;
    }
}
