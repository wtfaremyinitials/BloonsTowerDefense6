/**
 * A subclass of Bloon that is red
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class RedBloon extends Bloon {

    // Constructor takes a path to follow
    public RedBloon(Path path)
    {
        super(path); // Pass a path to follow
        setImage("./images/redbloon_sm.png"); // Set the image to a red bloon
    }

    // Constructor takes a path iterator to continue
    public RedBloon(PathIterator path)
    {
        super(path); // Pass a pathiterator to continue
        setImage("./images/redbloon_sm.png"); // Set the image to a red bloon
    }

    // When it is popped, only delete yourself
    public void pop() {
        getWorld().removeObject(this);
    }

    // get the number of bloons to be spawned when popped
    public int numInnerBloons() {
        return 0;
    }
}
