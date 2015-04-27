import greenfoot.*;

/**
 * Write a description of class GreenBloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GreenBloon extends Bloon
{  
    public GreenBloon(Path path)
    {
        super(path);
        setImage("./images/greenbloon_sm.png");
    } 
    
    public int numInnerBloons() {
        return 4;
    }
}

