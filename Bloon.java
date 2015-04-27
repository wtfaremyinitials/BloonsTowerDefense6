import greenfoot.*;

/**
 * An abstract class for a generic Bloon. (Yes the miss-spelling is intentional to stay true to the original)
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public abstract class Bloon extends ActorThatDoesntSuck
{
    // Path to follow
    private PathIterator it;

    // Constructor that takes a path to follow
    public Bloon(Path path) {
        it = new PathIterator(path);
    }

    // Constructor that takes a path iterator to continue
    public Bloon(PathIterator pathit) {
        it = pathit;
    }

    // Act method
    public void act()
    {
        Point next = it.next(); // Get the next point
        if(next == null) {
            ((BloonsWorld) getWorld()).decreaseLives(numInnerBloons() + 1); // delete yourself and decrease lives
            getWorld().removeObject(this);
        } else {
            moveTo(next); // Move to the point
        }
    }

    // Called when this Bloon is hit with a dart
    public void pop() {
        for(int i=0; i<numInnerBloons(); i++) { // Spawn a new RedBloon for every "innerBloon"
            PathIterator subIterator = it.clone(); // Clone the iterator to follow
            for(int j=0; j<i*10; j++) // Set them all slightly apart by advancing some more than others
                subIterator.next();
            getWorld().addObject(new RedBloon(subIterator), getX(), getY()); // Add the new Bloons
        };
        getWorld().removeObject(this); // Remove yourself
    }

    // Get the number of bloons to release when popped
    public abstract int numInnerBloons();

}
