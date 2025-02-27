package GreedyAlgorithms;

import java.util.ArrayList;

public class KthLargestOddNumbeRange {
   
    public static int findKthLarget(int L,int R ,int K){  // Inclusive L And R included

        int Kthodd=0;       // worst Time Complexity O(n)

        int nthOdd=0;

        ArrayList<Integer> oddnums=new ArrayList<>();

        for (int i = R; i >=L; i--) {
            
           // System.out.println(i);

            if (i%2!=0) {
                oddnums.add(i);
            }

        }
        if (K>oddnums.size()) {
            return 0;
        }

        return oddnums.get(K-1);
    }


    public static int optimumKthOddElement(int L,int R,int K){  //O(1)

       if (K<=0) return 0;

       // check both values must be even if not then do them by -1 to make esey to count

       int firstodd=(L%2==0)?L+1:L;        //L -starting  -4 = -4+1 =-3
       int lastOdd=(R%2==0)?R-1:R;      //R-ending

       //find the no. of add count

       int totalOdd=(lastOdd>=firstodd)?((lastOdd-firstodd)/2)+1:0; //that mens range id proper (3>-3)-coorect  (5>3) wrong

       if (K>totalOdd) return 0;
 

       // we subtract last odd with (k-1)*2 take we reverse find the odd numbers..
       
        return lastOdd-(K-1)*2;  //(3-(0*2))3     (3-(1*2))1     (3-(2*2))-1   (3-(2*3))-3

    }
        



    public static void main(String[] args) {
        
      //  System.out.println(findKthLarget(-3, 3, 1));
      System.out.println(optimumKthOddElement(-3, 3, 1)); // 3 (-3,-2,-1,0,1,2,3)
      System.out.println(optimumKthOddElement(-3, 3, 2)); // 1
      System.out.println(optimumKthOddElement(-3, 3, 3)); // -1
      System.out.println(optimumKthOddElement(-3, 3, 4)); // -3
      System.out.println(optimumKthOddElement(-3, 3, 5)); // 0 (out of range)
      
    }
}
