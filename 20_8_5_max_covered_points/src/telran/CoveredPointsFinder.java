package telran;

import java.util.*;

public class CoveredPointsFinder {

    public static int getMaxPointsNum(List<Double> nums, double L) {
        Deque<Double> interval = new LinkedList<>(nums);

        Iterator<Double> it = interval.iterator();
        Iterator<Double> secondIterator = interval.iterator();
        secondIterator.next();
        int amount = 0;
        int maxAmount = 0;
        double firstPointer = it.next();
        double secondPointer = secondIterator.next();

        while (it.hasNext() && secondIterator.hasNext()) {
            if (secondPointer - firstPointer <= L) {
                secondPointer = secondIterator.next();
                amount++;
                if (amount > maxAmount)
                    maxAmount = amount;
                continue;
            }
            if (secondPointer - firstPointer > L) {
                firstPointer = it.next();
                amount = 0;
            }
        }
        return maxAmount;
    }


/*   public int getMaxPointsNum(List<Double> points, double l) {
      Deque<Double> segment = new ArrayDeque<>();

      int res = 0;

      for (double point : points) {
         double leftEnd = point - l;
         segment.addLast(point);

         while (segment.getFirst() < leftEnd)
            segment.removeFirst();

         if (res < segment.size())
            res = segment.size();
      }

      return res;
   }*/
}
