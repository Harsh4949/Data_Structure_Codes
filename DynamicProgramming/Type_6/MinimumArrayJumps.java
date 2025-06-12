package DynamicProgramming.Type_6;

import java.util.Arrays;

import DynamicProgramming.Type_2.a0_1Knapsack;

public class MinimumArrayJumps {

    // we need to calculate the min number of jumps reqire to
    // *reach 1st elemnt to last elemnt in array*

    public static int minJupmsTab(int[] arr) {      //see image MinimumArrayJumpsDrurun.jpg
        
        int n=arr.length;
        int dp[]= new int[n];

        Arrays.fill(dp, -1);
        dp[n-1]=0;     
        
        for(int i=n-2;i>=0;i--){ // traverse last to start 
            int steps=arr[i];
            int ans=Integer.MAX_VALUE;

            for (int j = i+1; j <= i+steps && j<n; j++) {  // we need to jump only one step next it futher 
                                                  // assume the next step is calculated 
                System.out.println("i= "+i+" j= "+j + " steps= "+steps);

                if (dp[j]!=-1) {            // at 1st arr[n-1]=0 start fillin arry form that
                    ans=Math.min(ans, dp[j]+1);  // go to next step and 1 coz jump is done 
                }                                               
            }

            if (ans!=Integer.MAX_VALUE) {  // check if jump id done or Not (Case where 000 value is involve)
                dp[i]=ans;
            }
        }
        
        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println();
        return dp[0];
    }

    public static void main(String[] args) {    // see Output

        int nums[] = { 2, 3, 1, 1, 4 }; // min no. of jumps = 2

        System.out.println(minJupmsTab(nums));
    }
}
