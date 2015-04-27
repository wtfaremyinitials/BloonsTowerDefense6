import greenfoot.*;

import java.util.Random;
/**
 * Write a description of class BloonsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BloonsWorld extends World
{
    private Random rand;
    private Path path;
    private int delay;
    
    private int money;
    private int lives;
    
    public BloonsWorld() {    
        super(500, 500, 1);
        Greenfoot.setSpeed(60);
        setBackground("./images/map.png");
        path = new Path(new Point[]{
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
        delay = 0;
        rand = new Random();
        
        money = 200;
        lives = 200;
    }
    
    public void act() {
        showText("Lives: " + lives,  70, 10);
        showText("Money: $" + money, 70, 30);
        
        if(lives < 0) {
            Greenfoot.stop();
            if(Greenfoot.ask("Would you like to play again?").equalsIgnoreCase("yes")) {
                Greenfoot.setWorld(new BloonsWorld());
                Greenfoot.start();
            }
        }
        
        if(delay > 120) {
            Bloon b = null;
          
            switch(rand.nextInt(3)) {
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
            
            addObject(b, 0, 0);

            delay = 0;
        } else {
            delay++;
        }
    }
    
    public void decreaseLives(int deaths) {
        lives -= deaths;    
    }
    
    public void addMoney() {
        money++;
    }
    
    public void removeMoney(int cash) {
        money -= cash;
    }
    
    public int getMoney() {
        return money;
    }
}
