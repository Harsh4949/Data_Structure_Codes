package Array_quetions.Array2D;

public class searchSortedMatrix {

    public static int searchMatrix(int [][]matrix,int key){    //Time comlexcity O(n+m)

        int rowPtr=0;
        
        int colPtr=matrix[0].length-1;                      // searchMatrix starts from topright corner 1,0

        while( rowPtr<matrix.length && colPtr>=0){          //searchMatrix end to bottom left corner 4,0 
                                                            //do reverse if start form bottom left
            if (matrix[rowPtr][colPtr]==key) {

                System.out.println("("+rowPtr+","+colPtr+")");
                return 1;
            }
            else if (matrix[rowPtr][colPtr]<key) {

                rowPtr++;                                          //if key is > then go Down

            }else{
                
                colPtr--;                                           //else go left
            }

        }

        return -1;
        
    }

    public static void main(String[] args) {
        
        int [][]matrix={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};

        System.out.println(searchMatrix(matrix,3));
    }
    
}

//see the SS in this folder to explanation .

// searchMatrix can start only form topright or bottom left.