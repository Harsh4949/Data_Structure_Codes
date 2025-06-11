import java.util.Arrays;

import DynamicProgramming.Type_2.a0_1Knapsack;
import DynamicProgramming.Type_3.*;
public class MatrixChainMultiplication {

    public static int mcm(int[] arr,int i,int j) {
    
        if (i==j) {
            return 0; 
        }

        int ans= Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
                                          //                    a  X  b               c  X  d     == result MAtrix(a,d)
            int cost1=mcm(arr, i, k);   // Ai..Ak     ->  arr[i-1] X arr[i](A), arr[k-1] X arr[k] == arr[i-1] X arr[k]    // left tree call 
            int cost2=mcm(arr, k+1, j); // Ak+1....Kj ->  arr[k]   X arr[k+1] , arr[j-1] X arr[j] == arr[k] X arr[j]        //right tree call
            
            int cost3=arr[i-1]*arr[k]*arr[j];    // cost= a*b*d         
            
            int finalresult=cost1+cost2+cost3;  // see dry run to more understans "c:\Users\Harsh\Downloads\Phone Link\MCM_DryRun.jpg" 

            ans=Math.min(ans, finalresult);

        }

        return ans;
    }

    public static int mcmMemo(int arr[],int i,int j,int dp[][]){ // see recurtion call tree for understand

        if (i==j) {
            return 0;
        }

        if (dp[i][j]!=-1) {
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){

            int cost1 = mcmMemo(arr, i, k,dp);
            // Ai..Ak     ->  arr[i-1] X arr[i](A), arr[k-1] X arr[k] == arr[i-1] X arr[k]
            int cost2 =mcmMemo(arr, k+1, j, dp);
           // Ak+1....Kj ->  arr[k]   X arr[k+1] , arr[j-1] X arr[j] == arr[k] X arr[j] 

           int cost3 =arr[i-1]*arr[k]*arr[j]; //a*b*d

           int finalCostOprations=cost1+cost2+cost3;

           ans=Math.min(ans, finalCostOprations);
        }

        return dp[i][j]=ans;
    }

    public static void mcmTab(int[] arr) {
        
    }
    
    public static void main(String[] args) {

        int arr[]={1,2,3,4,3};  // A=1X2 , B= 2X3 ....
        int n= arr.length;
        System.out.println(mcm(arr, 1, n-1));

        int dp[][]= new int[n][n];

        for(int i=0;i<n;i++)
        Arrays.fill(dp[i], -1);

        System.out.println(mcmMemo(arr, 1, n-1, dp));
       // a0_1Knapsack.print(dp);

    }
}

//Dry Run : 
/* 
    mcm(1, 4)
    ├── k=1
    │    ├── cost1 = mcm(1,1) → 0
    │    ├── cost2 = mcm(2,4)
    │    │    ├── k=2
    │    │    │    ├── cost1 = mcm(2,2) → 0
    │    │    │    ├── cost2 = mcm(3,4)
    │    │    │    │    ├── k=3
    │    │    │    │    │    ├── cost1 = mcm(3,3) → 0
    │    │    │    │    │    ├── cost2 = mcm(4,4) → 0
    │    │    │    │    │    └── cost3 = arr[2]*arr[3]*arr[4] = 3*4*3 = 36
    │    │    │    │    └── finalCost = 0 + 0 + 36 = 36
    │    │    │    └── cost3 = arr[1]*arr[2]*arr[4] = 2*3*3 = 18
    │    │    │    └── finalCost = 0 + 36 + 18 = 54
    │    │    ├── k=3
    │    │    │    ├── cost1 = mcm(2,3)
    │    │    │    │    ├── k=2
    │    │    │    │    │    ├── cost1 = mcm(2,2) → 0
    │    │    │    │    │    ├── cost2 = mcm(3,3) → 0
    │    │    │    │    │    └── cost3 = arr[1]*arr[2]*arr[3] = 2*3*4 = 24
    │    │    │    │    └── finalCost = 24
    │    │    │    ├── cost2 = mcm(4,4) → 0
    │    │    │    └── cost3 = arr[1]*arr[3]*arr[4] = 2*4*3 = 24
    │    │    │    └── finalCost = 24 + 0 + 24 = 48
    │    │    └── min(54, 48) = 48
    │    └── cost3 = arr[0]*arr[1]*arr[4] = 1*2*3 = 6
    │    └── finalCost = 0 + 48 + 6 = 54
    ├── k=2
    │    ├── cost1 = mcm(1,2)
    │    │    ├── k=1
    │    │    │    ├── cost1 = mcm(1,1) → 0
    │    │    │    ├── cost2 = mcm(2,2) → 0
    │    │    │    └── cost3 = arr[0]*arr[1]*arr[2] = 1*2*3 = 6
    │    │    └── finalCost = 6
    │    ├── cost2 = mcm(3,4)
    │    │    ├── already computed above = 36
    │    ├── cost3 = arr[0]*arr[2]*arr[4] = 1*3*3 = 9
    │    └── finalCost = 6 + 36 + 9 = 51
    ├── k=3
    │    ├── cost1 = mcm(1,3)
    │    │    ├── k=1
    │    │    │    ├── mcm(1,1)=0
    │    │    │    ├── mcm(2,3) = already computed = 24
    │    │    │    └── cost3 = arr[0]*arr[1]*arr[3] = 1*2*4 = 8
    │    │    │    └── finalCost = 0 + 24 + 8 = 32
    │    │    ├── k=2
    │    │    │    ├── mcm(1,2)=6
    │    │    │    ├── mcm(3,3)=0
    │    │    │    └── cost3 = arr[0]*arr[2]*arr[3] = 1*3*4 = 12
    │    │    │    └── finalCost = 6 + 0 + 12 = 18
    │    │    └── min(32, 18) = 18
    │    ├── cost2 = mcm(4,4) = 0
    │    ├── cost3 = arr[0]*arr[3]*arr[4] = 1*4*3 = 12
    │    └── finalCost = 18 + 0 + 12 = 30
    └── min(54, 51, 30) = ✅ **30**

*/