import greenfoot.*;

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends ActorThatDoesntSuck
{
    private Bloon target;
    
    public Dart(Bloon target) {
        this.target = target;
        setImage("./images/dart_sm.png");
    }
   
    public void act() 
    {
        try {
            turnTowards(target.getX(), target.getY());
            move(3);
        
            if(intersects(target)) {
                target.pop(); 
                ((BloonsWorld) getWorld()).addMoney(); 
                getWorld().removeObject(this);
            }
        } catch(IllegalStateException e) {
            getWorld().removeObject(this);
        }   
    }    
}
