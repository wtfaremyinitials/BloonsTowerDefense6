/**
 * Write a description of class RedBloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBloon extends Bloon {
   
    public RedBloon(Path path)
    {
        super(path);
        setImage("./images/redbloon_sm.png");
    }
    
    public RedBloon(PathIterator path)
    {
        super(path);
        setImage("./images/redbloon_sm.png");
    }
    
    public void pop() {
        getWorld().removeObject(this);
    }
    
    public int numInnerBloons() {
        return 0;
    }
}
