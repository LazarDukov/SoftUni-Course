package PointInRectangle;

public class Rectangle {
    private final int bottomLeftX;
    private final int bottomLeftY;
    private final int topRightX;
    private final int topRightY;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    public boolean contains(Point point) {
        return check(point, bottomLeftX, bottomLeftY, topRightX, topRightY);

    }

    private boolean check(Point point, int... values) {
        if (point.getX() < bottomLeftX || point.getX() > topRightX) {
            return false;
        }
        if (point.getY() < bottomLeftY || point.getY() > topRightY) {
            return false;
        }
        return true;
    }
}