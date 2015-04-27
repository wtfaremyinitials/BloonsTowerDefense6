/**
 * A class to represent a point on the map
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class Point
{
    private int x; // The X coordinate
    private int y; // The Y coordinate

    // Constructor takes an x and y coordinate
    public Point(int x, int y)
    {
        this.x = x; // Set X
        this.y = y; // Set Y
    }

    // Get X
    public int getX()  {
        return x;
    }

    // Get Y
    public int getY() {
        return y;
    }

    // Check if one point is the same as another
    public boolean equals(Point that) {
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
}
