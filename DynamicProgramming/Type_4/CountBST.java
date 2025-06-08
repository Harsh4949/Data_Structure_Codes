package DynamicProgramming.Type_4;

public class CountBST {

    public static int catalanTab(int n) { //O(n^2)

        int dp[] = new int[n+1];
        dp[0]=1; // Null tree
        dp[1]=1; // 1 with 1 node have only One Bst forms

        for (int j = 2; j <= n; j++) {
        
            for (int i = 0; i < j; i++) {  // Same As Catalan's Number Logic

                int leftT=dp[i];
                int rightT=dp[j-i-1];
                dp[j]+=leftT*rightT;
            }
        }
        
        for (int i : dp) {
            System.out.print(i+" ");
        }
        System.out.println();
        return dp[n];
    }


    public static void main(String[] args) {
        
        int n =4;//(10 20 30 40)

        System.out.println(catalanTab(n));
    }
    
   
}
