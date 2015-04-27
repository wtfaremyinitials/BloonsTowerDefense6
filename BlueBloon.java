import greenfoot.*;

/**
 * Write a description of class BlueBloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBloon extends Bloon
{  
    public BlueBloon(Path path)
    {
        super(path);
        setImage("./images/bluebloon_sm.png");
    } 
    
    public int numInnerBloons() {
        return 2;
    }
}
