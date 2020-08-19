package telran;

import java.util.Comparator;

public class VectorAngleComparatorDesc implements Comparator<Point2D> {
    @Override
    public int compare(Point2D o1, Point2D o2) {
        if (o1.angleSize() == o2.angleSize())
            return 0;
        else if (o1.angleSize() < o2.angleSize())
            return 1;
        else return -1;
    }
}
