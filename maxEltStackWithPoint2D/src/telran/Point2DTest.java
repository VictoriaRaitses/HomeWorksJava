package telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {
    Point2D point2D = new Point2D(3.56, 4.78);

    @Test
    public void testGetX_getFirstCoordinate_3() {
        assertEquals(3.56, point2D.getX());
    }

    @Test
    public void testGetY_getSecondCoordinate_4() {
        assertEquals(4.78, point2D.getY());
    }

    @Test
    public void testVectorLength_pointCoordinates_5() {
        assertEquals(5.960033556952512, point2D.vectorLength());
    }

    @Test
    public void testCompareTo_zeroLength_0() {
        Point2D point2D = new Point2D(0, 0);
        assertEquals(0, point2D.compareTo(new Point2D(0, 0)));
    }

    @Test
    public void testCompareTo_sameLength_0() {
        assertEquals(0, point2D.compareTo(new Point2D(3.56, 4.78)));
    }

    @Test
    public void testCompareTo_smaller() {
        assertEquals(-1, point2D.compareTo(new Point2D(19.56, 14.78)));
    }

    @Test
    public void testCompareTo_bigger() {
        assertEquals(1, point2D.compareTo(new Point2D(0, 0.1)));
    }
}