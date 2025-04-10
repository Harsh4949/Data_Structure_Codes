package DynamicProgramming.Type_1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClimbingStairs {

    public static int countWays(int n) {    //normal recursion draw tree O(2^N)
        
        if (n==0) {
            return 1;
        }

        if (n<0) {
            return 0;
        }

        return countWays(n-1)+countWays(n-2);
    }

    public static int countWaysDp(int n,int ways[]){      //same logic as fbinanci see thier code and images for understnading

        if (n==0) {
            return 1;
        }

        if (n<0) {
            return 0;
        }

        if (ways[n]!=-1) {
            return ways[n];
        }

        return ways[n]=countWaysDp(n-1, ways)+countWaysDp(n-2, ways);
    }
    
    public static void main(String[] args) {
        
        int n=5;
        System.out.println(countWays(5));

        int[] ways= new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(countWaysDp(n, ways));
        //System.out.println(ways[n]);
    }
}
