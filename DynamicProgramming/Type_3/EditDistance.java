package DynamicProgramming.Type_3;
import DynamicProgramming.Type_2.*;

public class EditDistance {     // See the EditDistanceLogic.png for UnderStanding 

    public static int editDistanceTab(String str1,String str2) {
        
        int n=str1.length(),m=str2.length();
        int dp[][]=new int[n+1][m+1];

        // initialization If any String Is empty Then
        //The Total Operartion Reqied is : Length Of Another String

        for (int i = 0; i < n+1; i++) {      // Fill 0th row 
            dp[0][i]=i;
        }

        for (int i = 1; i < m+1; i++) {   // Fill 0th column 
            dp[i][0]=i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                
                if (str1.charAt(i-1)==str2.charAt(j-1)) {      
                    dp[i][j]=dp[i-1][j-1];      // No Opration Reqire If Both Char Same                } else {
                    
                }else{

                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;

                    dp[i][j]=Math.min(add, Math.min(del, rep));
                }
            }
        }

        a0_1Knapsack.print(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        
        String str1="abc";
        String str2="sbd";

        System.out.println("Oprations Reqired To make 1st String As 2nd : "+editDistanceTab(str1, str2));

       // System.out.println("Oprations Reqired To make 1st String As 2nd : "+editDistanceTab("inention", "exection"));

    }
}