package DynamicProgramming.Type_3;
import DynamicProgramming.Type_2.*;
import java.util.Arrays;

public class LCS {      //Longest Common Subsequence 

    // in this Quetion We need to find //Longest Common Subsequence between Two String
    //but The relative order Of the chracter Of the String are Must be same or incresingly
    
    public static int LCS(String str1,String str2,int n,int m) { // See Logic in LCSLogic.png image
        
        if (n==0 || m==0) {
            return 0;
        }

        if (str1.charAt(n-1)==str2.charAt(m-1)) { 
            // if last two char are same then reduce the size of String By 1
            //And Add 1 in Answer 
            return LCS(str1, str2, n-1, m-1)+1;
        } else {
            // if not same then Make Two Call bye Redusing size bye Each One
            return Math.max(LCS(str1, str2, n-1, m), LCS(str1, str2, n, m-1));  
        }
    }

    public static int LCSMemo(String str1,String str2,int n,int m,int dp[][]){

        if (n==0||m==0) {
            return 0;
        }

        if (dp[n][m]!=-1) {
            return dp[n][m];
        }

        if (str1.charAt(n-1)==str2.charAt(m-1)) {
            return dp[n][m]=LCSMemo(str1, str2, n-1, m-1, dp)+1;

        } else {
        
            return dp[n][m] = Math.max(LCSMemo(str1, str2, n-1, m,dp), LCSMemo(str1, str2, n, m-1,dp));  
        }
    }

    public static int LCSTab(String str1,String str2){
        
        int n=str1.length();
        int m=str2.length();
        int dp[][]= new int[n+1][m+1];

        //initialize if The Length Of Both String Are Zero 

        // for (int i = 0; i < n+1; i++) {           
        //     for (int j = 0; j < m+1; j++) {
        //         if (i==0 ||j==0) {
        //             dp[i][j]=0;                     //Not needed In Java
        //         }
        //     }
        // }

        for (int i = 1; i < n+1; i++) {     
            for (int j = 1; j < m+1; j++) {
                
                if (str1.charAt(i-1)==str2.charAt(j-1)) {       // see The Image LCSTabLogic For DryRun And Logic
                    
                    dp[i][j]=dp[i-1][j-1]+1;

                } else {

                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }

        System.out.println();
        a0_1Knapsack.print(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        
        String str1="abcde";
        String str2="ace";
        System.out.println(LCS(str1, str2, str1.length(), str2.length()));

        int dp[][]= new int[str1.length()+1][str2.length()+1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(LCSMemo(str1, str2, str1.length(), str2.length(), dp));
        a0_1Knapsack.print(dp);

        System.out.println(LCSTab(str1, str2));
    }
}
