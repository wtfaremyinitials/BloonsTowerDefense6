import greenfoot.*;

import java.util.Random;
/**
 * A subclass of World which handles all of the main logic of the game
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class BloonsWorld extends World
{
    private Random rand; // Random object for bloon color
    private Path path;   // Path for the bloons to follow
    private int delay;   // Counter to delay bloon spawn

    private int money;   // How much money the player has
    private int lives;   // How many lives the player has

    // Empty constructor
    public BloonsWorld() {
        super(500, 500, 1); // 500x500 world at 1x scale
        Greenfoot.setSpeed(60); // Set world speed to reasonable default
        setBackground("./images/map.png"); // Set background to the map
        path = new Path(new Point[]{ // Create the path for the bloons to follow
            new Point(450, 0),
            new Point(450, 150),
            new Point(370, 150),
            new Point(370, 75),
            new Point(60 , 75),
            new Point(60 , 260),
            new Point(130, 260),
            new Point(130, 175),
            new Point(185, 175),
            new Point(185, 260),
            new Point(245, 260),
            new Point(245, 175),
            new Point(305, 175),
            new Point(305, 350),
            new Point(375, 350),
            new Point(375, 235),
            new Point(450, 235),
            new Point(450, 425),
            new Point(230, 425),
            new Point(230, 350),
            new Point(0  , 350)
        });
        delay = 0; // Set the bloon counter to 0
        rand = new Random(); // Initialize random

        money = 200; // Start with 200 money
        lives = 200; // Start with 200 lives
    }

    // Act method for World
    public void act() {
        showText("Lives: " + lives,  70, 10); // Draw number of lives to screen
        showText("Money: $" + money, 70, 30); // Draw amount of money to screen

        if(lives < 0) { // If the player is out of lives, show the game over
            Greenfoot.stop(); // Stop the game
            if(Greenfoot.ask("Would you like to play again?").equalsIgnoreCase("yes")) { // Ask to play again
                Greenfoot.setWorld(new BloonsWorld()); // Reset world
                Greenfoot.start(); // Start game
            }
        }

        if(delay > 120) { // Check the counter for bloon spawning
            Bloon b = null; // Initialize bloon

            switch(rand.nextInt(3)) { // Randomly choose bloon color
            case 0:
                b = new RedBloon(path);
                break;
            case 1:
                b = new BlueBloon(path);
                break;
            case 2:
                b = new GreenBloon(path);
                break;
            }

            addObject(b, 0, 0); // Add Bloon to world

            delay = 0; // Reset counter
        } else {
            delay++; // Increment counter
        }
    }

    // Subtract x number of lives from the scoreboard
    public void decreaseLives(int deaths) {
        lives -= deaths;
    }

    // Add 1 to the amount of money
    public void addMoney() {
        money++;
    }


    // Remove x number of money from the scoreboard
    public void removeMoney(int cash) {
        money -= cash;
    }

    // Get the amount of money on the scoreboard
    public int getMoney() {
        return money;
    }
}
