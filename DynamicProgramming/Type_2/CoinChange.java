package DynamicProgramming.Type_2;

public class CoinChange {

    // In this Quetion We have coins[]={2,5,3,6} and Sum 10
    // we need to find the Number Of Ways(Using the combibnation Of Given Coins were One coin can Add Mutltiple Time)
    // we want to return the Total number Of Ways
    
    public static int coinChangeTab(int conis[],int sum){   // Similer To Unbounded KnapSack

        int n= conis.length+1;
        int dp[][]= new int[n][sum+1];

        //initialize dp 

        for (int i = 0; i < n; i++) { // if sum is 0 the 1 way (i.e We does not Give Any Thing Even we Have Mutilple Coins)
            dp[i][0]=1;             // initailze column
        }

        // for (int i = 1; i < sum+1; i++) { // But if the conis are zero then 0 ways for Above 1 sum (Coz We have to coins)
        //     dp[0][i]=0;             // initailze row Not Need to initilalize in JAva
            
        // }

        for (int i = 1; i < n; i++) {           // Now fill the remaining part...
            for (int j = 1; j < sum+1; j++) {
                
                if (conis[i-1]<=j) {  // check the coin is less than Equal sum(j)
                    //if Yes then Include And Exclude
                    // include mens Add me add Fill reming part [j-conis[i-1]]
                    // Exclude Mens Dont add me exludeing me Fill the part From other coins

                    dp[i][j] = dp[i][j-conis[i-1]] + dp[i-1][j];

                    // we need to retun totl No. Of Ways to we add it.
                    
                } else { // If No only Exclude
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        a0_1Knapsack.print(dp);
        return dp[n-1][sum];
    }

    public static void main(String[] args) {
        
        int coins[]={2,5,3,6};
        int sum=10;

        System.out.println(coinChangeTab(coins, sum));

    }
}