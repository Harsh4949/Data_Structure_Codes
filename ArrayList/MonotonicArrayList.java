package ArrayList;

import java.util.*;

public class MonotonicArrayList {
    
    public static boolean findMonoMatic(ArrayList nums){

        boolean Inc=true;
        boolean Dec=true;

        for(int i=0;i<nums.size()-1;i++){

            if ((int)nums.get(i)<(int)nums.get(i+1)) {
                Inc=false;
            }
            if ((int)nums.get(i)>(int)nums.get(i+1)) {
                Dec=false;
            }

        }

        return Inc ||Dec;
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> nums=new ArrayList<>();

        nums.add(6);// nums = [6,5,4,4] 
        nums.add(5);
        nums.add(4);
        nums.add(4);

        System.out.println(findMonoMatic(nums));
    }
}

/*
 * 
    Sample Input 1 : nums = [1,2,2,3] 
    Sample Output 1 : true 

    Sample Input 2 : nums = [6,5,4,4] 
    Sample Output 2 : true 

    Sample Input 3 : nums = [1,3,2] 
    Sample Output 3 : false
    
 */