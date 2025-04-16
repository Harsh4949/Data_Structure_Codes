package DynamicProgramming.Type_2;

import DynamicProgramming.Type_2.a0_1Knapsack;

public class MinimumPathSum {
    
    public static int minimumPathSum(int[][] grid,int m,int n) {    // Dp Top-Down Approch Start at Max index to min index
        
        //Base Case  

        if (m==0 && n==0) {               
            return grid[0][0]; 
        }

        //Boundry Consition

        if (m<0 || n<0) {
            return Integer.MAX_VALUE; // coz we get min path here 
        }
        // in this probelm we can go only down and right 
        // were we start from last row column See Image "MinimumPathSumDiagram.png"
        // so we reverse it as per diagram.
                        //               top                          left
        return grid[m][n]+Math.min(minimumPathSum(grid, m-1, n), minimumPathSum(grid, m, n-1));
    }

    public static int minimumPathMemo(int[][] grid,int m,int n, int dp[][]) {    // Dp Top-Down Approch Start at Max index to min index
        
        //Base Case  
        if (m==0 && n==0) {               
            return grid[0][0]; 
        }

        //Boundry Consition
        if (m<0 || n<0) {
            return Integer.MAX_VALUE; // coz we get min path here 
        }


        if (dp[m][n]!=0) {
            return dp[m][n];
        }

        // in this probelm we can go only down and right 
        // were we start from last row column See Image "MinimumPathSumDiagram.png"
        // so we reverse it as per diagram.
                        //               top                          left
        return dp[m][n]=(grid[m][n]+Math.min(minimumPathSum(grid, m-1, n), minimumPathSum(grid, m, n-1)));
    }

    public static int minimumPathTab(int[][] grid) {
        
        int dp[][]= new int[grid.length][grid[0].length];

        // in tabulation we crete a one dp array
        // ** IMP :  in tabulation we always initialize 1st Row And 1st Column With Basic Logic Based on Quetion 
        // And perForm Tabulation Form 1st Row And 1st Column

         // as given the we Can go Only Down And Right

        dp[0][0]=grid[0][0]; // always Same
      
        for (int i = 1; i < dp.length; i++) {   // for filling 1st Column
            
            // Only for Right- Right Condition, so let fill 1st Row

            dp[0][i]=dp[0][i-1]+grid[0][i];     // get the sum of Evry Cell
        }

        for (int i = 1; i < dp.length; i++) {   // for filling 1st Row
            
            // Only for Down- Down Condition, so let fill 1st Column

            dp[i][0]=dp[i-1][0]+grid[i][0];     // get the sum of Evry Cell
           
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                dp[i][j]=Math.min(grid[i][j]+dp[i-1][j], grid[i][j]+dp[i][j-1]);
            }
        }

        a0_1Knapsack.print(dp);
        return dp[grid.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        
        int grid[][]={{1,3,1},{1,5,1},{4,2,1}};
        int dp[][]= new int[grid.length][grid[0].length];

        System.out.println(minimumPathSum(grid, grid.length-1, grid[0].length-1));

        System.out.println(minimumPathMemo(grid, grid.length-1, grid[0].length-1, dp));
        System.out.println("Memoisaton Dp : ");
        a0_1Knapsack.print(dp);

        System.out.println("\n Tabulation Dp : ");
        System.out.println(minimumPathTab(grid));
        
        
        
    }
}
