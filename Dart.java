import greenfoot.*;

/**
 * A class to represent a dart thrown at a bloon
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class Dart extends ActorThatDoesntSuck
{
    private static int DART_SPEED = 3;
    private Bloon target; // The bloon that the dart is following

    // Constructor that takes a Bloon to target
    public Dart(Bloon target) {
        this.target = target; // Set the target variable
        setImage("./images/dart_sm.png"); // Set the image to a dart
    }

    // Act method to track target
    public void act()
    {
        try {
            turnTowards(target.getX(), target.getY()); // Turn towards the target
            move(DART_SPEED); // Move forward

            if(intersects(target)) { // If it hit the bloon
                target.pop(); // Pop the bloon
                ((BloonsWorld) getWorld()).addMoney(); // Increment the money counter
                getWorld().removeObject(this); // Remove the dart
            }
        } catch(IllegalStateException e) {
            getWorld().removeObject(this); // If the bloon doesn't exist anymore, delete yourself
        }
    }
}
