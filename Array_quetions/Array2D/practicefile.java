package Array_quetions.Array2D;

import java.util.*;
public class practicefile {

    public static void waterContainer(int[] arr) {  //Brute force
        int maxwater=0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++ ){
                int height = Math.min(arr[i], arr[j]);
                int width = j-i;
                maxwater=Math.max(maxwater,width*height);
            }
        }

        System.out.println(maxwater);
    }

   public static void main(String[] args) {
    
    int []arr={1,8,6,2,5,4,8,3,7};
        waterContainer(arr);
   }
}
