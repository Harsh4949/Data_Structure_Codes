package DynamicProgramming.Type_3;
import DynamicProgramming.Type_2.*;
import java.util.TreeSet;
public class LongestIncreasingSubsequence {
    

    public static int LCS(int[] arr1,int[]arr2) {
        int n= arr1.length;
        int m = arr2.length;

        int dp[][]= new int[n+1][m+1];

         //initialize if The n or m One Or Both Arrays Are Zero 

        // for (int i = 0; i < n+1; i++) {           
        //     for (int j = 0; j < m+1; j++) {
        //         if (i==0 ||j==0) {
        //             dp[i][j]=0;                     //Not needed In Java
        //         }
        //     }
        // }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
             
                if (arr1[i-1]==arr2[j-1]) {
                    dp[i][j]=dp[i-1][j-1]+1;

                } else {
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }

        a0_1Knapsack.print(dp);
        return dp[m][n];
    }

    public static int LISTab(int[] arr1) {
        
        TreeSet<Integer> set = new TreeSet<>(); // Inserd as per the sorting Order(asending)

        for (Integer num : arr1) {
            set.add(num);
        }
        
        int arr2[] = new int[set.size()];
        int i=0;
        
        for (Integer num : set) {
            arr2[i++]=num;
        }

        //Arrys.Sort(arr2) // if not Use tree Map It Sort Asending Order
        return LCS(arr1, arr2);
    }

    public static void main(String[] args) {
        
        int arr1[]={50,3,10,7,40,80};

        System.out.println(LISTab(arr1));
    }
}
