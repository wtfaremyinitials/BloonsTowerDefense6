import greenfoot.*;

/**
 * A subclass of Actor that has setX and setY, because Greenfoot left them out
 * for no good reason.
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class ActorThatDoesntSuck extends Actor
{
    // Set the actor's X coordinate
    public void setX(int x) {
        int rot = getRotation(); // Get initial rotation
        int deltaX = x- getX();  // Find distance from target
        setRotation(0);          // Turn towards target
        move(deltaX);            // Move correct distance
        setRotation(rot);        // Reset rotation
    }

    // Set the actor's Y coordinate
    public void setY(int y) {
        int rot = getRotation(); // Get initial rotation
        int deltaY = y - getY(); // Find distance from target
        setRotation(90);         // Turn towards target
        move(deltaY);            // Move correct distance
        setRotation(rot);        // Reset rotation
    }

    // Set the actor's X and Y coordinates to that of a Point
    public void moveTo(Point point) {
        setX(point.getX()); // Set X coordinate
        setY(point.getY()); // Set Y coordinate
    }
}
