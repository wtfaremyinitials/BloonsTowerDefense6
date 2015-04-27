import greenfoot.*;

/**
 * Write a description of class Bloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Bloon extends ActorThatDoesntSuck
{
    private PathIterator it;
    
    public Bloon(Path path) {
        it = new PathIterator(path);
    }
    
    public Bloon(PathIterator pathit) {
        it = pathit;
    }
   
    public void act() 
    {
        Point next = it.next();
        if(next == null) {
            ((BloonsWorld) getWorld()).decreaseLives(numInnerBloons() + 1);
            getWorld().removeObject(this);
        } else {
            moveTo(next);
        }
    }
    
    public void pop() {
        for(int i=0; i<numInnerBloons(); i++) {
            PathIterator subIterator = it.clone();
            for(int j=0; j<i*10; j++)
                subIterator.next();
            getWorld().addObject(new RedBloon(subIterator), getX(), getY());
        };
        getWorld().removeObject(this);
    }
    
    public abstract int numInnerBloons();
    
}
