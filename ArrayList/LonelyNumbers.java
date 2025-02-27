package ArrayList;

import java.util.ArrayList;

public class LonelyNumbers {
    
    public static void findLonelyNums(ArrayList<Integer> nums) {
        
        ArrayList<Integer> lonelyNums = new ArrayList<>();
        int[] arr = new int[106]; 

        
        for (int num : nums) {
            arr[num]++;
        }

       
        for (int i = 0; i < arr.length; i++) {
          
            if (arr[i] == 1 && 
                (i == 0 || arr[i - 1] == 0) && 
                (i == arr.length - 1 || arr[i + 1] == 0)) {
                lonelyNums.add(i);
            }
        }

        System.out.println(lonelyNums);
    }


    public static void main(String[] args) {
        
        ArrayList<Integer> num=new ArrayList<>();

        num.add(3);
        num.add(5);
        num.add(3);
        num.add(1);
        num.add(9);

        findLonelyNums(num);
      

    }
}

/*
 *  
 * Sample Input 2 : nums = [1,3,5,3] 
    Sample Output 2 : [1,5]
    this one can aslo done using sorting the list using Collection.sort(list)
         then the Comlexity->O(n log n)
 */