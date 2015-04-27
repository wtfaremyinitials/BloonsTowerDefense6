/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point  
{
    private int x;
    private int y;
    
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()  {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean equals(Point that) {
        return this.getX() == that.getX() && this.getY() == that.getY();
    }
}
