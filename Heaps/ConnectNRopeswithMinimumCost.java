package Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class ConnectNRopeswithMinimumCost {
    
    public static int connectNRops(int rops[]){

        PriorityQueue<Integer> rope= new PriorityQueue<>(Collections.reverseOrder());
        int ans=0;

        for (Integer i : rops) {
            rope.add(i);
        }

        while (rope.size()!=1) {

            int r1=rope.remove();
            int r2=rope.remove();
            ans+=r1+r2;      // 5+9+15 =29
            rope.add(r1+r2);
        }

        return ans;
       
    }

    public static void main(String[] args) {
        
        int rops[]={4,3,2,6};

        System.out.println(connectNRops(rops));
    }
}
