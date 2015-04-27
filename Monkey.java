import greenfoot.*;
import java.util.List;

/**
 * A class to represent a monkey that throws darts
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class Monkey extends ActorThatDoesntSuck
{
    private static int DEFAULT_DELAY = 100;
    private static int DEFAULT_RANGE = 150;
    private static int DEFAULT_PRICE = 100;

    private int delay; // The time between throws
    private int range; // How far the monkey can throw
    private int time;  // The counter that ticks toward the `delay`

    private boolean paid; // If the monkey has been paid for
    private int price; // How expensive the monkey is

    // Constuctor for a basic Monkey
    public Monkey() {
        delay = DEFAULT_DELAY; // 100 ticks of delay
        range = DEFAULT_RANGE; // Range of 150
        price = DEFAULT_PRICE; // Costs $100
        setImage("./images/monkey.png"); // Set the image to a simple monkey
        paid = false; // This unit has not yet been paid for
    }

    // Constuctor for a Monkey with the given stats
    public Monkey(int delay, int range, int price) {
        this(); // Call basic constructor to set defaults
        this.delay = delay; // Set delay
        this.range = range; // Set range
        this.price = price; // Set price
    }

    // Act method to throw darts
    public void act()
    {

        if(!paid) { // If this unit hasn't been paid for yet
            if(price <= ((BloonsWorld) getWorld()).getMoney()) { // If the player has enough
                ((BloonsWorld) getWorld()).removeMoney(price); // Subtract the price from money count
                paid = true; // The unit has been paid for
            } else {
                 getWorld().removeObject(this); // Unit can't be paid for, delete it
            }
        }

        if(delay < time) { // If it's time to throw a dart
            List<Actor> possible = getObjectsInRange(range, Bloon.class); // Look for possible targets

            if(possible.size() == 0) // If there is none, give up
                return;

            Bloon target = (Bloon) possible.get(0); // Get the first possible target
            turnTowards(target.getX(), target.getY()); // Turn towards it
            getWorld().addObject(new Dart(target), getX(), getY()); // Spawn a dart targeting it

            time = 0; // Reset timer
        }else {
            time++; // Increment timer
        }
    }
}
