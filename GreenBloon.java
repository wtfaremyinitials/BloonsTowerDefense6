import greenfoot.*;

/**
 * Write a description of class GreenBloon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreenBloon extends Bloon
{
    // A simple constuctor that takes a path to follow
    public GreenBloon(Path path)
    {
        super(path); // Pass the path on to super
        setImage("./images/greenbloon_sm.png"); // Set the image to a green bloon
    }

    // Get the number of bloons to spawn when popping
    public int numInnerBloons() {
        return 4;
    }
}
