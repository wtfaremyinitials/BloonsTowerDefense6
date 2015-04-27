import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Monkey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monkey extends ActorThatDoesntSuck
{   
    private int delay;
    private int range;
    private int time;
    
    private boolean paid;
    private int price;
    
    public Monkey() {
        delay = 100;
        range = 150;
        price = 100;
        setImage("./images/monkey.png");
        paid = false;
    }
    
    public Monkey(int delay, int range, int price) {
        this();
        this.delay = delay;
        this.range = range;
        this.price = price;
    }
    
    public void act() 
    {
        
        if(!paid) {
            if(price <= ((BloonsWorld) getWorld()).getMoney()) {
                ((BloonsWorld) getWorld()).removeMoney(price);
                paid = true;
            } else {
                 getWorld().removeObject(this);
            }
        }
       
        if(delay < time) {
            List<Actor> possible = getObjectsInRange(range, Bloon.class);
            
            if(possible.size() == 0)
                return;
                
            Bloon target = (Bloon) possible.get(0);
            turnTowards(target.getX(), target.getY());
            getWorld().addObject(new Dart(target), getX(), getY());

            time = 0;
        }else {
            time++;
        }
    }    
}
