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

        if (n<0) {                 
            return 0;
        }

        if (n==0) {
           // System.out.println("hello");
            return 1;
        }

        if (ways[n]!=-1) {                      //memoization
            return ways[n];
        }
        

        return ways[n]=countWaysDp(n-1, ways)+countWaysDp(n-2, ways);
    }


    public static int countWaysDpTab(int n){

        int dp[]= new int[n+1];
        dp[0]=1;

        for (int i = 1; i <=n; i++) {
            
            if (i==1) {   
                dp[i]=dp[i-1]+0;  //1-2 = -1 wichi is false to add 0 for understnading

            } else {
                
                dp[i]=dp[i-1]+dp[i-2];
            }
        }

        return dp[n];

    }
    
    public static void main(String[] args) {
        
        int n=5;
        System.out.println("simple Recursion :"+countWays(5));

        int[] ways= new int[n+1];
        Arrays.fill(ways, -1);
       // ways[0]=1; also done

        System.out.println("Memoization : "+countWaysDp(n, ways));
        //System.out.println(ways[n]);

        System.out.println("Tabulation: "+countWaysDpTab(n));
    }
}
