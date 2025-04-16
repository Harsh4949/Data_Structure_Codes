package DynamicProgramming.Type_2;
import DynamicProgramming.Type_2.a0_1Knapsack;
public class UnboundedKnapsack {

    public static int knapsackDPTab(int val[],int wt[],int W){      //see dry run in nootbook Page : 22 jan 2025

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

        a0_1Knapsack.print(dp);

        return dp[val.length][W];
    }
    

    public static int unboundedKnapsackTab(int [] val, int wt[],int W){     //see dry run in nootbook Page : 26 jan 2025

        int n=val.length;
        int dp[][]= new int[n+1][W+1];

        //Condition 1 : if Capacity of KnapSack is 0 , then initalize hole column of Capacity to Zero;
        //              in java that not need to initialize 0 coz it bydefault

        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }

        //Condition 2 : if Number of items is 0 , then initalize hole row to Zero coz Not make profit if no item present;
        //              in java that not need to initialize 0 coz it bydefault

        for (int i = 0; i < dp.length; i++) {
            dp[0][i]=0;
        }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int v=val[i-1];
                int w=wt[i-1];

                if (w<=j) {     //Current if wt is less than cur W(i.e -j)
                    // include 
                    int ans1= v+dp[i][j-w];     //** in unbounded knapsack we add one items Multiple time until it fill**
                   
                    //exclude 
                    int ans2= dp[i-1][j];

                    dp[i][j]=Math.max(ans1, ans2);
                    
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        a0_1Knapsack.print(dp);

        return dp[n][W];
    }


    public static void main(String[] args) {
        
        int val[]={15,14,10,45,30}; // cost of each weight
        int wt[]={2,5,1,3,4};      // weight
        int W=7;        // Max capacity of Bag
        System.out.println("Simpe Knapsack : ");
        System.out.println(knapsackDPTab(val, wt, W));

        System.out.println("\nUnbounded Knapsack : ");
        System.out.println(unboundedKnapsackTab(val, wt, W));
    }
}
