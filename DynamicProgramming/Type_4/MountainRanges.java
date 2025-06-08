package DynamicProgramming.Type_4;

public class MountainRanges {

    public static int mountainRangeTab(int n) {
        
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i <=n; i++) {

            for (int j = 0; j <i; j++) {

                int inside=dp[j];
                int outside=dp[i-j-1]; 
                
                dp[i]+=inside*outside;

            }
        }

        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println();

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n=4; // 14

        System.out.println(mountainRangeTab(n));
    }
}
