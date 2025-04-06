package Graphs;

public class FloodFillAlgo {


    public static void helper(int[][] image,int sc,int sr,int color,int orignal ){
        
        if (sr<0 || sc<0||sr>=image.length||sc>=image[0].length|| image[sr][sc]!=orignal || image[sr][sc] == color
        ) {
            return;
        }

        image[sr][sc] =color;


        //left 
        helper(image, sc-1, sr, color,orignal);
        //right
        helper(image, sc+1, sr, color,orignal);
        //down
        helper(image, sc, sr+1, color,orignal);
        //up
        helper(image, sc, sr-1, color,orignal);
    }
    
    public static int[][] floodFill(int[][] image,int sc,int sr,int color){  // sr:startRow ,sc :startColumn

        helper(image, sc, sr, color,image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };        

        image=floodFill(image, 1, 1, 2);

        for (int[] is : image) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
        
    }
}
