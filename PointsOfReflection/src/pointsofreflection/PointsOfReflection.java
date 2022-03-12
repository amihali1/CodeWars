/*
 * "Point reflection" or "point symmetry" is a basic concept in geometry
 * where a given point, P, at a given position relative to a mid-point, Q has a corresponding point, P1, which is the same distance from Q but in the opposite direction.
 * Task
 * Given two points P and Q, output the symmetric point of point P about Q. 
 * Each argument is a two-element array of integers representing the point's X and Y coordinates. 
 * Output should be in the same format, giving the X and Y coordinates of point P1. You do not have to validate the input.
 */
package pointsofreflection;

/**
 *
 * @author rvc
 */
public class PointsOfReflection
{


    public static void main(String[] args)
    {
        var retVal = reflectPoint(new int[]{1000,15}, new int[]{-7,-214});
        
        if (retVal[0] != -1014 && retVal[1] != -443)
            System.out.println("Loser :(");
        else 
            System.out.println("Winner!");
    }
    
    public static int[] reflectPoint(int[] p, int[] q) 
    {
        int pX = p[0];
        int pY = p[1];

        int qX = q[0];
        int qY = q[1];

        var xDist = qX - pX;
        var yDist = qY - pY;

        return new int[]{qX + xDist, qY + yDist};
  }
    
}
