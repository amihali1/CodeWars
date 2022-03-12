/*
 * Wikipedia: The regular paperfolding sequence, also known as the dragon curve sequence, 
 * is an infinite automatic sequence of 0s and 1s 
 * defined as the limit of inserting an alternating sequence of 1s and 0s around and between the terms of the previous sequence:
 * 1
 * 110
 * 1101100
 * 110110011100100 
*/
package paperfoldsequence;

import java.util.*;

/**
Note how each intermediate sequence is a prefix of the next.

Define a generator PaperFold that sequentially generates the values of this sequence:

1 1 0 1 1 0 0 1 1 1 0 0 1 0 0 1 1 1 0 1 1 0 0 0 1 1 0 0 1 0 0 ...

It will be tested for up to 1 000 000 values.
 */
public class PaperFold
{
    int sequenceIteration;
    ArrayList<Integer> sequence;
    public PaperFold()
    {
        sequence = new ArrayList();
        sequence.add(1);
        sequenceIteration = 0;
    }
    

    public static void main(String[] args)
    {
        testWithTwenty();
    }
 
    public int getAsInt()
    {
        if (sequenceIteration == 0)
        {
            sequenceIteration++;
            return 1;
        }
        
        int sequenceNum;
        var len = sequence.size()*2;
        var nextSequence = new ArrayList<Integer>();        
        var j = 0;
        var nextInt = 1;
        
        if (sequence.size()-1 < sequenceIteration)
        {
          for (int i = 0; i <= len; i++)
          {
            if (i%2 == 0)
            {
                nextSequence.add(nextInt); 
                nextInt = nextInt == 0 ? 1 : 0;
            }                
            else
            {
                nextSequence.add(sequence.get(j));
                j++;
            }
          }
          
          for (int i = sequence.size(); i < nextSequence.size(); i++)
              sequence.add(nextSequence.get(i));          
        }
               
        sequenceNum = sequence.get(sequenceIteration);
        sequenceIteration++;
       
        return sequenceNum;
    }
    public static void testWithTwenty() 
    {
        PaperFold p = new PaperFold();
        int testArray[] = {1,1,0,1,1,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1};
        for(int i=0; i<20; i++) 
        {
            System.out.println("        i | t[i] | p[i]");
            System.out.printf("Element %d,|  %d,  |  %d", (i+1), testArray[i],  p.getAsInt());
        }
    }
}
