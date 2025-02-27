package Array_quetions.Array2D;

public class diagonalSum {

    public static int displaySum(int [][]matrix){

 
        int sum=0;

        //  for(int i=0;i<matrix.length;i++){          //brust force O(n^2)
        //     for(int j=0;j<matrix[0].length;j++){

        //         if(i==j||(i+j)==matrix.length-1){
        //             sum+=matrix[i][j];
        //         }
        //     }
        //  }

        for(int i=0;i<matrix.length;i++){       // best case O(n)

            sum+=matrix[i][i];

            if (i!=matrix.length-1-i) {
                sum+=matrix[i][matrix.length-1-i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int matrix2[][]={{0,1,2},{3,4,5},{6,7,8}};

        System.out.println(displaySum(matrix2));
        System.out.println(displaySum(matrix));
    }
}