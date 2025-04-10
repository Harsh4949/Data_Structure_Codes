package DynamicProgramming.Type_1;


public class Tribonanci {
    
    public static int tribonanciDp(int n, int[]dp) {       // O(n)  repetative call are avoid See Image Must
                                                    // time complecity goes low coz Skowed recursion tree is foemed
        if (n==0||n==1) {
            return 0;
        }

        if (n==2) {
            return 1;
        }

        // dp[n]=fibDp(n-1, dp)+fibDp(n-2, dp);
        // return dp[n];

        return dp[n]=tribonanciDp(n-1, dp)+tribonanciDp(n-2, dp)+tribonanciDp(n-3, dp); // one line logic
    }

    public static int trifibTabuler(int n){ // O(n) another Way of DP without Recursion

        int dp[] = new int[n+1];

        dp[0]=0;
        dp[1]=0; // dp[0]=0,1=1 as we give in recusion base condition
        dp[2]=1;

        for (int i = 3; i <=n; i++) {
            
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];

    }

    public static void main(String[] args) {

        int n=6;
        
        int[] dp =new int [n+1]; // index :0 To n-1  this array is calles as Memoization DP

        System.out.println(tribonanciDp(n, dp));

        System.out.println(trifibTabuler(n));
    }
}
