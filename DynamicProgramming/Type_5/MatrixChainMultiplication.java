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

//Dry Run mcmMemo : 
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

/*
 * Dry Run MCM Tab: 
 * 

        int arr[] = {1, 2, 3, 4, 3}; // n = 5
        ```

        This means we have 4 matrices:

        * A1: 1×2
        * A2: 2×3
        * A3: 3×4
        * A4: 4×3

        ### 📘 **Key Understanding**

        Let:

        * `dp[i][j]` represent the **minimum cost** to multiply matrices from `i` to `j`.
        * We use **bottom-up tabulation** with a matrix `dp[n][n]` where `n = arr.length`.

        Initial setup:

        * Diagonal `dp[i][i] = 0` because multiplying one matrix needs no cost.

        ---

        ## 🧮 **Dry Run with Key Variable Tracking**

        ### 🔁 **Outer Loop**: `len` from 2 to 4

        ---

        ### ✅ `len = 2` (Window size = 2 matrices)

        We compute costs for:

        * `(1, 2)`
        * `(2, 3)`
        * `(3, 4)`

        #### ➤ i = 1, j = 2

            ```java
            k = 1
            cost1 = dp[1][1] = 0
            cost2 = dp[2][2] = 0
            cost3 = arr[0] * arr[1] * arr[2] = 1*2*3 = 6
            dp[1][2] = 6
            ```

        #### ➤ i = 2, j = 3

        ```java
        k = 2
        cost1 = 0, cost2 = 0
        cost3 = 2*3*4 = 24
        dp[2][3] = 24
        ```

        #### ➤ i = 3, j = 4

        ```java
        k = 3
        cost1 = 0, cost2 = 0
        cost3 = 3*4*3 = 36
        dp[3][4] = 36
        ```

        📊 DP Matrix after `len = 2`:

        ```
            0 1  2  3  4
        0 [ - -  -  -  - ]
        1 [ - 0  6  -  - ]
        2 [ - - 0 24  - ]
        3 [ - - - 0 36 ]
        4 [ - - - - 0 ]
        ```

        ---

        ### ✅ `len = 3` (Window size = 3 matrices)

        We compute costs for:

        * `(1, 3)`
        * `(2, 4)`

        #### ➤ i = 1, j = 3

        Try all k from 1 to 2

        **k = 1**

        ```java
        cost1 = dp[1][1] = 0
        cost2 = dp[2][3] = 24
        cost3 = 1*2*4 = 8
        total = 0 + 24 + 8 = 32
        ```

        **k = 2**

        ```java
        cost1 = dp[1][2] = 6
        cost2 = dp[3][3] = 0
        cost3 = 1*3*4 = 12
        total = 6 + 0 + 12 = 18 → min
        ```

        ✅ dp\[1]\[3] = **18**

        #### ➤ i = 2, j = 4

        **k = 2**

        ```java
        cost1 = 0
        cost2 = 36
        cost3 = 2*3*3 = 18
        total = 0 + 36 + 18 = 54
        ```

        **k = 3**

        ```java
        cost1 = 24
        cost2 = 0
        cost3 = 2*4*3 = 24
        total = 24 + 0 + 24 = 48 → min
        ```

        ✅ dp\[2]\[4] = **48**

        📊 DP Matrix after `len = 3`:

        ```
            0 1  2  3  4
        0 [ - -  -  -  - ]
        1 [ - 0  6 18  - ]
        2 [ - - 0 24 48 ]
        3 [ - - - 0 36 ]
        4 [ - - - - 0 ]
        ```

        ---

        ### ✅ `len = 4` (Window size = 4 matrices)

        Only one full chain: `(1, 4)`

        Try k = 1, 2, 3

        **k = 1**

        ```java
        cost1 = dp[1][1] = 0
        cost2 = dp[2][4] = 48
        cost3 = 1*2*3 = 6
        total = 0 + 48 + 6 = 54
        ```

        **k = 2**

        ```java
        cost1 = 6
        cost2 = 36
        cost3 = 1*3*3 = 9
        total = 6 + 36 + 9 = 51
        ```

        **k = 3**

        ```java
        cost1 = 18
        cost2 = 0
        cost3 = 1*4*3 = 12
        total = 18 + 0 + 12 = 30 → ✅ minimum
        ```

        ✅ dp\[1]\[4] = **30**

        📊 Final DP Matrix:

        ```
            0 1  2  3  4
        0 [ - -  -  -  - ]
        1 [ - 0  6 18 30 ]
        2 [ - - 0 24 48 ]
        3 [ - - - 0 36 ]
        4 [ - - - - 0 ]
        ```

        ---

        ### ✅ Final Answer:

        ```java
        return dp[1][4] = 30
        ```

 */