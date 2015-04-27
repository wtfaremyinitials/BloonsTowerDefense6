import greenfoot.*;

/**
 * A subclass of Monkey that slowly fires with a high range
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class SniperMonkey extends Monkey
{
    // A constructor for SniperMonkey
    public SniperMonkey() {
        super(500, 10000, 300); // Pass stats to the Monkey constructor
        setImage("./images/snipermonkey.png"); // Set the image to a sniper
    }
}
