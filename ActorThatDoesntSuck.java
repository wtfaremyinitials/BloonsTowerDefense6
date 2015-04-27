import greenfoot.*;

/**
 * Write a description of class ActorThatDoesntSuck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActorThatDoesntSuck extends Actor
{
    public void setX(int x) {
        int rot = getRotation();
        int deltaX = x- getX();
        setRotation(0);
        move(deltaX);
        setRotation(rot);
    }
    
    public void setY(int y) {
        int rot = getRotation();
        int deltaY = y - getY();
        setRotation(90);
        move(deltaY);
        setRotation(rot);
    }
    
    public void moveTo(Point point) {
        setX(point.getX());
        setY(point.getY());
    }
}
