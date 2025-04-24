package DynamicProgramming.Type_3;
import DynamicProgramming.Type_2.*;

public class EditDistance {

    public static int editDistanceTab(String str1,String str2) {
        
        int n=str1.length(),m=str2.length();
        int dp[][]=new int[n+1][m+1];

        for (int i = 0; i < dp.length; i++) {
            
        }

        for (int i = 0; i < dp.length; i++) {
            
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                
            }
        }
        
        a0_1Knapsack.print(dp);
        return dp[n][m];
    }

    public static void main(String[] args) {
        
        String str1="abc";
        String str2="sbd";

        System.out.println("Oprations Reqired To make 1st String As 2nd : "+editDistanceTab(str1, str2));

    }
}