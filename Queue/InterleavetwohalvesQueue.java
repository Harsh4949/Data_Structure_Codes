package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class InterleavetwohalvesQueue {
    
    public static void interLeaveTwoHalvesQueue(Queue<Integer> q){

        Queue<Integer> firtHalf=new ArrayDeque<>();

        int mid=q.size()/2;

        for(int i=0;i<mid;i++){

            firtHalf.add(q.remove());           // store firtHalf 1-5
        }
 
        while (!firtHalf.isEmpty()) {
                   

            q.add(firtHalf.remove());    //add 1 at last
            q.add(q.remove());                // //remove 6 form start and add 6 at end

        }
    }



    public static void main(String[] args) {
        
        Queue<Integer> q=new ArrayDeque<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        
        interLeaveTwoHalvesQueue(q);

        while (!q.isEmpty()) {
            System.out.print(" "+q.remove());
        }

    }
}
