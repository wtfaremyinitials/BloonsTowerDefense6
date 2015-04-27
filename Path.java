/**
 * A class to hold a set of Points. Doesn't do much, I assumed it would have to do more.
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class Path
{
    private Point[] points; // The points

    // Constructor that takes an array of points
    public Path(Point[] points)
    {
        this.points = points; // Set the points array
    }

    // Get the points
    public Point[] getPoints() {
        return points;
    }
}
