import greenfoot.*;

/**
 * A sublass of the generic Bloon class that represents a blue one
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class BlueBloon extends Bloon
{
    // Simple constructor
    public BlueBloon(Path path)
    {
        super(path); // Call super
        setImage("./images/bluebloon_sm.png"); // Set the correct image
    }

    // Get the number of bloons to create on pop
    public int numInnerBloons() {
        return 2;
    }
}
