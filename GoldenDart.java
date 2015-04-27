import greenfoot.*;

/**
 * A subclass of Dart that was meant to appear gold that never got finished
 *
 * @author Will Franzen
 * @version 1.0.0
 */
public class GoldenDart extends Dart
{
    // Simple constructor that takes a target
    public GoldenDart(Bloon target) {
        super(target); // Call super with target
        setImage("./images/dart_gold.png"); // Set the image to a golden dart
    }
}
