package ArrayList;

import java.util.ArrayList;

public class pairsumSortedArray {
    
  public static boolean pairSumBrute(ArrayList list,int target) {  //Brute force O(n^2)

        for(int i=0;i<list.size();i++){

            for(int j=i+1;j<list.size();j++ ){

                if ((int)list.get(i)+(int)list.get(j)==target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean pairSumOptimum(ArrayList list,int target) { // O(n) two pinter Approch

        int lp=0;                // left pointer
        int rp=list.size()-1;    //right pointer

      
        while (lp<rp) {
            
            if ((int)list.get(lp)+(int)list.get(rp)==target) {
                return true;
            }
            else if ((int)list.get(lp)+(int)list.get(rp) < target) {
                lp++;
            }
            else
                rp--;

        }


        return false;
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> list=new ArrayList<>();      //if list is sorted given 

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(pairSumBrute(list, 5));
        System.out.println();

        System.out.println(pairSumOptimum(list, 5));
    }
}

/*
 * [1,2,3,4,5,6]
 * lp         rp
 *  6+1=7--> rp--;
 * else
 *    lp++
 * 
 */