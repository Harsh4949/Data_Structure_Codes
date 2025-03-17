import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {
    

    public static int[] twosum(int arr[],int target){  // return two number that have sum targrt

        HashMap<Integer, Integer> visited = new HashMap<>(); // 2

        for(int i = 0; i<arr.length; i++) { 

            //diff = given target - number given at ith index

            int diff = target - arr[i];   //9-2 =7 , 9-7 =2
    
            if(visited.containsKey(diff)) { // 7 not cantions , 2 presnet

                return new int[] { i, visited.get(diff) }; 
            } 

            visited.put(arr[i],i);  // add 2 ,0

        } 

        //if no matches are found 
            return new int[] {0, 0};
    }

    public static void main(String[] args) {
        
        int arr[]={2,7,11,15};
        int result[]=twosum(arr, 9);
        for (int i : result) {
            System.out.println(i);
        }
    
    }
}
