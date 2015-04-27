import greenfoot.*;

/**
 * A subclass of Monkey that fires extremely fast with a relatively low range
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class SuperMonkey extends Monkey
{
    // A constructor for SuperMonkey
    public SuperMonkey() {
        super(30, 200, 2000); // Pass stats to the Monkey constructor
        setImage("./images/supermonkey.png"); // Set the image to a super monkey
    }
}
