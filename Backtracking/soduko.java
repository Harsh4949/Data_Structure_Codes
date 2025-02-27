package Backtracking;

public class soduko {

    public static boolean isSolveSoduko(int[][] bord,int row,int col) {
        
        //base case

        if (row == bord.length) {
            return true;
        }

        // Move to the next row if we reach the end of the current row
        if (col == bord[0].length) {
            return isSolveSoduko(bord, row + 1, 0);
        }

        // Skip already filled cells
        if (bord[row][col] != 0) {
            return isSolveSoduko(bord, row, col + 1);
        }
        //recursion

       // Try placing numbers 1-9 in the current cell
       for (int num = 1; num <= 9; num++) {
            if (isSafe(bord, row, col, num)) {
                bord[row][col] = num; // Place the number

                // Recur to check if placing this number leads to a solution
                if (isSolveSoduko(bord, row, col + 1)) {
                    return true;
                }

                // Backtrack if placing the number doesn't lead to a solution
                bord[row][col] = 0;
            }
        }

        // If no number works, backtrack
        return false;

    }
    
    
    public static boolean isSafe(int[][] board,int row,int col,int num){


          // Check row and column
          for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
                            //4   -(4%3)
                            //4-1 = 3   
        int subGridRowStart = row - (row % 3);  // will give the starting row of the grid...
        int subGridColStart = col - (col % 3);  //// will give the starting col of the grid...
        
        for (int i = subGridRowStart; i < subGridRowStart + 3; i++) {
            for (int j = subGridColStart; j < subGridColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBord(int[][] args) {
        
        System.out.println("-------------Soduko----------------");

        for(int i=0;i<args.length;i++){
            for(int j=0;j<args[0].length;j++){
                System.out.print(args[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        

        if(isSolveSoduko(board,0,0)){
            System.out.println("soduko is Solved");
            printBord(board);
        }else
            System.out.println("soduko not is Solved");
    }        
}
