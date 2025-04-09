package DynamicProgramming;

public class FibnanciSeries {
    
    public static int fabNormal(int n){ //O(n^2) - worst Exponensial 

        if(n==0||n==1) return n;

        return fabNormal(n-1)+fabNormal(n-2);  
        // see the recursion tree in Image that have many recursive  repetatavie call are goes 
        //due to time complexity goes high..
        // to overcome this Dp is used..
    }

    public static int fibDp(int n, int[]dp) {       // O(n)  repetative call are avoid See Image Must
                                                    // time complecity goes low coz Skowed recursion tree is foemed
        if (n==0||n==1) {
            return n;
        }

        // dp[n]=fibDp(n-1, dp)+fibDp(n-2, dp);
        // return dp[n];

        return dp[n]=fibDp(n-1, dp)+fibDp(n-2, dp); // one line logic
    }

    public static int fibTabuler(int n){ // O(n) another Way of DP without Recursion

        int dp[] = new int[n+1];

        dp[1]=1; // dp[0]=0,1=1 as we give in recusion base condition

        for (int i = 2; i <=n; i++) {
            
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    public static void main(String[] args) {

        int n=6;
        System.out.println(fabNormal(n));
        
        int[] dp =new int [n+1]; // index :0 To n-1  this array is calles as Memoization DP

        System.out.println(fibDp(n, dp));

        System.out.println(fibTabuler(n));
    }
}
