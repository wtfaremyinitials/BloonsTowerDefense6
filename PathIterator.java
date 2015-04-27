/**
 * Write a description of class PathIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PathIterator  
{    
     private Path path;
     private Point target;
     private int targetIndex;
     private Point last;
    
     public PathIterator(Path path) {
         this.path = path;
         this.targetIndex = 0;
         this.target = path.getPoints()[targetIndex];
         this.last = path.getPoints()[targetIndex];
     }
     
     public Point next() {
         if(last.equals(target)) {
             targetIndex++;
             if(targetIndex == path.getPoints().length)
                 return null;
             target = path.getPoints()[targetIndex];
         }
         
         int x = last.getX();
         int y = last.getY();
         
         if(target.getX() > last.getX())
             x++;
         if(target.getX() < last.getX())
             x--;
         if(target.getY() > last.getY())
             y++;
         if(target.getY() < last.getY())
             y--;
             
         return (last = new Point(x, y));
     }
     
     public PathIterator clone() {
         PathIterator n = new PathIterator(path);
         n.path = path;
         n.target = target;
         n.targetIndex = targetIndex;
         n.last = last;
         return n;
     }
}
