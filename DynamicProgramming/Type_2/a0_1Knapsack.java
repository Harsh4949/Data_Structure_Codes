package DynamicProgramming.Type_2;

import java.util.Arrays;

public class a0_1Knapsack {

    public static int knapsackDPMemo(int val[],int wt[],int W,int cur,int dp[][]) { //O(N*M)
        
        if (W==0||cur==0) {
            return 0;
        }

        if(dp[W][cur]!=-1){
            return dp[W][cur];
        }

        if (wt[cur-1]<=W) {
            
            int ans1=val[cur-1]+knapsackDPMemo(val, wt, W-wt[cur-1], cur-1, dp);
            int ans2=knapsackDPMemo(val, wt, W, cur-1, dp);
            
            return dp[W][cur]=Math.max(ans1, ans2);
        }else{

            return dp[W][cur]=knapsackDPMemo(val, wt, W, cur-1, dp);
        }
    }

    public static void print(int [][] dp) {
        
        for (int[] is : dp) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
    }
    
    public static int knapsackDPTab(int val[],int wt[],int W){

        int[][]dp= new int[val.length+1][W+1];  // wxtra size taken for this base condition
        
        for (int i = 0; i < val.length+1; i++) { 
            dp[i][0]=0;             // if item list is is 0 column 0
        }

        for (int i = 0; i < W+1; i++) {
            dp[0][i]=0;             // if capacity is 0 then hole column is zero initialized..
        }

        for (int i = 1; i < val.length+1; i++) {       // where i is itemas and weight
            
            for (int j = 1; j < W+1; j++) {       // j is capacity (W)
                
                int v=val[i-1];   // 0 to val.length it goes
                int w=wt[i-1];   // same

                if (w<=j) {  // w current weight
                    
                    int incProfit=v+dp[i-1][j-w]; //include weight
                    int exeProfit=dp[i-1][j]; //include weight
                    dp[i][j]=Math.max(incProfit, exeProfit);

                } else {
                     dp[i][j]=dp[i-1][j]; // exclude if weight is grater than capacity..
                }
            }
        }

        print(dp);

        return dp[val.length][W];
    }

    public static int maxProfit(int val[],int wt[],int W,int cur){//O(2^n)

        if (cur==0 || W==0) {
            return 0;
        }
        
       // int finalans;
        if (wt[cur-1]<=W) {

        // where we include the cur weight and value
            int profit1=val[cur-1]+maxProfit(val, wt, W-wt[cur-1], cur-1); // cur point to form the last to 1st elemnts in arry.
                        //add then value of itself while returning.. imp
            // // where we exlude the cur weight and value see dry run for understnding...

            int profit2=maxProfit(val, wt, W, cur-1); // we does not include weight and value

            return Math.max(profit1, profit2);

        }else{// if bag if full... then exclude

            return maxProfit(val, wt, W, cur-1);
        }

       // return finalans;
    }

    public static void main(String[] args) {    // there are 2 possiblity of evry weight/product were it include or exclude so we use two recusion call.
        
        int val[]={15,14,10,45,30}; // cost of each weight
        int wt[]={2,5,1,3,4};      // weight
        int W=7;        // Max capacity of Bag
        int dp[][] = new int[W+1][val.length+1];

            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }


        System.out.println(knapsackDPMemo(val, wt, W, val.length, dp));
        System.out.println(maxProfit(val, wt, W, val.length));
System.out.println();
        System.out.println(knapsackDPTab(val, wt, W));
    }
}
