package DynamicProgramming.Type_4;

import static org.junit.Assert.fail;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CatalansNumber {

    // to fins 4 we need to calculte like nCr 
    //C4 = C0*C3  + C1*C2 + C2*C1 + C3*C0 

    //using Recursion

    public static int catalanRec(int n) {
        

        if (n==0||n==1) {
            return 1; // as per given Image  "CatalansNumberLogic.png"
        }

        int ans=0;

        for (int i = 0; i < n; i++) {  //0-3
            
            ans+=catalanRec(i)*catalanRec(n-i-1); // ex  : 4-0-1 =3 
        }

        return ans;
    }

     //using Recursion Memoization

    public static int catalanMemo(int n,int dp[]) {
        
        if (n==0||n==1) {
            return 1;
        }

        if (dp[n]!=-1) {
            return dp[n];
        }
        
        int ans=0;
        for (int i = 0; i < n; i++) {
            
            ans+=catalanMemo(i,dp)*catalanMemo(n-i-1, dp);
        }

        return dp[n]=ans;
    }

     //using Tabulation

    public static int catalanTab(int n) { //O(n*n)

        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int j = 2; j <= n; j++) {
            
            int ans=0;

            for (int i = 0; i < j; i++) {
                ans+=dp[i]*dp[j-i-1];
            }
            dp[j]=ans;
        }
        
        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println();
        return dp[n];
    }


    public static void main(String[] args) {
        
        int n =4;

        System.out.println(catalanRec(n));
        int dp[]= new int[n+1];

        Arrays.fill( dp,-1);
        System.out.println(catalanMemo(n, dp));

        System.out.println(catalanTab(n));
    }
}


