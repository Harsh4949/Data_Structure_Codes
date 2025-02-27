package Queue;
import java.util.*;

public class ConnectNRopesWithMinimumCost {

    public static int minCost(int[]nRops){

        int mincostTotal=0;
        PriorityQueue<Integer> q=new PriorityQueue<>();  // it automatically sort the elelmt i.e placer in appropiat order

        for (int i : nRops) {
            q.add(i);
        }
       
       
        while (q.size()>=2) {
            
            int firstRope=q.poll();         
            int SecondRope=q.poll();

            mincostTotal+=(firstRope+SecondRope);   //do addition and insert at last of queue ie.. rear

            q.add(firstRope+SecondRope);
        }

        return mincostTotal;

    }


    public static void main(String[] args) {
        
        int len[] = { 4, 3, 2, 6 }; 
        int len2[] = { 1,2,3 }; 
        int size = len.length; 
        System.out.println("Total cost for connecting : "+size+" is  : "+minCost(len));
        System.out.println("Total cost for connecting : "+size+" is  : "+minCost(len2));
    
        
    }
}


//https://youtu.be/_k_c9nqzKN0?si=JZfXxEHqV9-gc_FV

/*
 * 
 *      1 2 3   always do additon of small numbers to get a minimum cost
 *      1+2 |
 *       3+3
 *         6
 *                       mincot=3+6 = 9 
 * 
 * 
 * 
 *  PriorityQueue Operations:
 * 
            Step	PriorityQueue   (min-heap)	            Action
             1  	[2, 3, 4, 6]	Initial heap    
             2	    [4, 5, 6]	    Merge 2 + 3 = 5     (Cost += 5) imp step
             3	    [6, 9]	        Merge 4 + 5 = 9     (Cost += 9)
             4	    [15]	        Merge 6 + 9 = 15    (Cost += 15)



Why PriorityQueue?
                A PriorityQueue in Java is a min-heap by default, 
            meaning it always keeps the smallest element at the top. The operations like insertion 
            (offer) and removal of the smallest element (poll) happen in O(log N) time complexity.

Why Not a Simple Queue?
             A simple queue (Queue<Integer>) in Java follows a FIFO (First In, First Out) principle,
        meaning elements are removed in the same order they were inserted. However, our problem
        requires accessing and removing the smallest two elements repeatedly, which a simple queue
        cannot do efficiently.

 */