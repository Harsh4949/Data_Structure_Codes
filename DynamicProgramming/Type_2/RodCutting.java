package DynamicProgramming.Type_2;

public class RodCutting {

    //lenght =W , val=Price , wt=length
    // see / revise the logic of Unbounded KanapSack Coz Quetion is Same

    public static int rodCuttingTab(int[] length,int[]price,int rodLength){  // same as unbounded KnapSack

        int n=price.length;
        int dp[][]=new int[n+1][rodLength+1];

        //initialize Not nees in java if Not 0

        // for (int i = 0; i < dp.length; i++) {        // if Rod length is Zero
        //     for (int j = 0; j < dp.length; j++) {    // if price id Zero
        //         if (i==0 || j==0) {
        //             dp[i][j]=0;
        //         }
        //     }
        // }


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < rodLength+1; j++) {
                
                if (length[i-1]<=j) {

                    dp[i][j]= Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                    
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        a0_1Knapsack.print(dp);
        return dp[n][rodLength];
    }    

    public static void main(String[] args) {
        
        int length[]={1,2,3,4,5,6,7,8};
        int price[] ={1,5,8,9,10,17,17,20};
        int rodLength=8;

        System.out.println(rodCuttingTab(length, price, rodLength));
    }
}
