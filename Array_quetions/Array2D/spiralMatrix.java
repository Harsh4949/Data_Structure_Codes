package Array_quetions.Array2D;

public class spiralMatrix {

    public static void spiralMatrix_display(int [][]numarry){

        int startRow=0;
        int startCol=0;
        int endRow=numarry.length-1;
        int endCol=numarry[0].length-1;

        while (startRow<=endRow && startCol<=endCol) {
            

            for(int i=startCol;i<=endCol;i++){
                System.out.print(" "+numarry[startRow][i]);       //it will print 1,2,3,4 TOP
            }


            for(int j=startRow+1;j<=endRow;j++){
                System.out.print(" "+numarry[j][endCol]);         //it will print 8,12,16 right side
            }

            for(int i=endCol-1;i>=startCol;i--){
                
                if (startRow==endRow) {
                    break;
                }
                
                System.out.print(" "+numarry[endRow][i]);       //it will print 15,14,13 Bottom
            }


            for(int j=endRow-1;j>=startRow+1;j--){

                if(startCol==endCol){
                    break;
                }
                
                System.out.print(" "+numarry[j][startCol]);         //it will print 9,5 left side
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
       
    }

    public static void main(String[] args) {

        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        spiralMatrix_display(matrix);
    }
}

//    1   2   3   4
//    5   6   7   8
//    9  10  11  12
//   13  14  15  16

//use while loop{

    //print Top part of Matrix 1,2,3,4
    //print right part boundry 4,8,12,16 where 4 is alrady printed in 1st loop
    //print bottom part 16,15,14,13 where 16 is alrady printed in 2st loop
    //print left part 13,9,5,1 where 1,13 is alrady printed in 1st&3rd loop
    // startCol++;
    // startRow++;
    // endCol--;
    // endRow--;

// }
