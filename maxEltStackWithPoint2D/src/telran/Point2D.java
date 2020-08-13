package telran;

public class Point2D implements Comparable<Point2D> {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double vectorLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    }

    @Override
    public int compareTo(Point2D anotherPoint2D) {
        if (this.vectorLength() == anotherPoint2D.vectorLength())
            return 0;
        else if (this.vectorLength() < anotherPoint2D.vectorLength())
            return -1;
        else return 1;
    }

    @Override
    public boolean equals(Object other) {
        Point2D otherPoint = (Point2D) other;

        return this.x == otherPoint.x && this.y == otherPoint.y;
    }


}