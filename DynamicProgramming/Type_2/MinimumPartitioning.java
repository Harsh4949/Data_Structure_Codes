package DynamicProgramming.Type_2;

public class MinimumPartitioning {

    public static int minpartitionTab(int[] arr) {
        
    
        int sum=0;
        for (int s : arr) { 
            sum+=s;     // 24
        }
        
        int n=arr.length;
        int W=sum/2;      //12
        
        int dp[][]= new int[n+1][W+1];  //value ,W

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {  // size of bag
                
                if (arr[i-1]<=j) {
                    
                    //include bag
                    int include=arr[i-1]+dp[i-1][j-arr[i-1]];
                    // exlcude bag
                    int exclude=dp[i-1][j];

                    dp[i][j]=Math.max(include, exclude); // see were the maximum bag will be fill
                }else{      //if full

                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        a0_1Knapsack.print(dp);

        int sum1 = dp[n][W];
        int sum2 = sum-sum1;
        int diff = Math.abs(sum1-sum2);

        return diff;

    }
    
    public static void main(String[] args) {
        
        int members[]={1,6,11,5};     // min differecne 1
                                     // we need to return minimum differtce 
                                     // after partioning  arr in two part as given in image

        System.out.println(minpartitionTab(members));
    }
}
