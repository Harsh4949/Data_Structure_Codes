package DynamicProgramming.Type_2;

public class TargetSumSubset {

    public static void print(boolean dp[][]){
        int i=0;
        for (boolean[] is : dp) {
            System.out.print("i="+(i++)+" |");
            for (boolean is2 : is) {
                System.out.print(" "+is2+" |");
            }
            System.out.println();
        }
    }

    public static boolean targetSumSubsetTab(int num[], int sum){   //see Dry run in NootBooK Page : 24 jan 2025

        boolean dp[][]= new boolean[num.length+1][sum+1];

        for (int i = 0; i < dp.length; i++) { // Condition 1: if the sum is 0 given then this clumn always true
            dp[i][0]=true;                      // see SS TargetSumSub_3.png
        }

        //Condition 2 : if no items are given then row of sum is alwyas false coz sum not calculated
        // Not need to initialize Fasle java automatically do that

        for (int i = 1; i < num.length+1; i++) {// Represent the items  see 2D aarry In TargetSumSub_3.png
            for (int j = 1; j < sum+1; j++) {   // represent the sum at evry column

                int v= num[i-1]; // i-1 coz nums index start form zero and end n-1

                //include item in sum is addition goes Equal to Sum and Less than Sum
                if (v<=j && dp[i-1][j-v]==true) {
                    // include 
                    dp[i][j]=true;
                }

                else if (dp[i-1][j]==true) {  // otherwise exclude , Like Knapsak No need to write Twice exlude 
                    //exlude
                    dp[i][j]=true;
                }
            }
        }

        print(dp);
        return dp[num.length][sum]; // return the last row last column that calculated answer
    }
    
    public static void main(String[] args) {
        
        int nums[]={4,2,7,1,3};
        int sum=10;

        System.out.println(targetSumSubsetTab(nums, sum));
    }
}
