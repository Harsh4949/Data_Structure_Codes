package Backtracking;

import Array_quetions.rotatedarry_Search;

public class NQurens {
    
    public static boolean isSafe(char [][] bord,int row ,int col) {
        
        //check upword queen exits ?

        for(int i=row-1;i>=0;i--){

            if (bord[i][col]=='Q') {
                return false;
            }
        }

        //check LEFT upword queen exits ?

        for(int i=row-1, j=col-1; i>=0 &&j>=0; i--, j--){
            if (bord[i][j]=='Q') {
                return false;
            }
        }
        
        //check RIGHT upword queen exits ?
        
        for(int i=row-1,j=col+1;i>=0&&j<bord.length;i--,j++){
            
            if (bord[i][j]=='Q') {
                return false;
            }
        }


        return true;
    }

    public static void nQurens(char[][] bord,int row) {
        
        //base case 

        if (row==bord.length) {
            printBord(bord);
            return;
        }

        //recurtion

        for(int j=0;j<bord.length;j++){     // call goes n time for 1 times for 2 n times here n is 2 consider

            if(isSafe(bord, row, j)){

                bord[row][j]='Q';
                nQurens(bord, row+1); //call
                bord[row][j]='x'; //backtrack

            }
        }                                   // so we get 4 combination
    }


    public static boolean NqueenNIspossible(char[][] bord,int row) {
        
        if (row==bord.length) {
            printBord(bord);
            return true;
        }

        //recurtion

        for(int j=0;j<bord.length;j++){     // call goes n time for 1 times for 2 n times here n is 2 consider

            if(isSafe(bord, row, j)){

                bord[row][j]='Q';
                if(NqueenNIspossible(bord, row+1)){
                    return true;
                }
                bord[row][j]='x'; //backtrack

            }
        }   

        return false;
    }
    public static void printBord(char[][] args) {
        
        System.out.println("--------------Queen Bord--------------");
        for(int i=0;i<args.length;i++){
            for(int j=0;j<args[0].length;j++){
                System.out.print(args[i][j]+" ");
            }
            System.out.println();
        }
            
    }
    
    public static void main(String[] args) {
        
        int n=4;
        char bord[][]=new char[n][n];

        for(int i=0;i<bord.length;i++){
            for(int j=0;j<bord[0].length;j++){
                bord[i][j]='x';
            }
        }

        nQurens(bord,0);

        // if (NqueenNIspossible(bord, 0)) {
        //     System.out.println("solution is possible");
        // }else{
        //     System.out.println("solution is NOt possible");
        // }
      
    }
}

//first we need to print the number of combinataion using recurstion
//then do place queen if it is safe (for that write function that return boolean value)
