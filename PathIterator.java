/**
 * An Iterator class that returns points that are steps between points on a Path.
 *
 * @author Will Franzenr
 * @version 1.0.0
 */
public class PathIterator
{
     private Path path; // The path to follow
     private Point target; // The point currently working towards
     private int targetIndex; // The index of the target
     private Point last; // The last point returned

     // Constructor, accepts a path to follow
     public PathIterator(Path path) {
         this.path = path; // Set the path
         this.targetIndex = 0; // Set the target index
         this.target = path.getPoints()[targetIndex]; // Set the target to the first point
         this.last = path.getPoints()[targetIndex]; // Set the last point to be the first point
     }

     // Get the next point on the path
     public Point next() {
         if(last.equals(target)) { // If the last one returned was the target
             targetIndex++; // Increment the targetIndex
             if(targetIndex == path.getPoints().length) // Check if it was the final point
                 return null;
             target = path.getPoints()[targetIndex]; // Set the new target
         }

         int x = last.getX(); // Get X from the last point
         int y = last.getY(); // Get Y from the last point

         // Add or subtract one to bring the point a step closer
         if(target.getX() > last.getX())
             x++;
         if(target.getX() < last.getX())
             x--;
         if(target.getY() > last.getY())
             y++;
         if(target.getY() < last.getY())
             y--;

         return (last = new Point(x, y)); // Return a point with the new cooridnates
     }

     // Return a duplicate of itself
     public PathIterator clone() {
         PathIterator n = new PathIterator(path); // Create a new PathIterator
         n.path = path; // Set path
         n.target = target; // Set target
         n.targetIndex = targetIndex; // Set targetIndex
         n.last = last; // Set last
         return n; // return it
     }
}
