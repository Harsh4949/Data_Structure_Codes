package ArrayList;

import java.util.ArrayList;

public class PairSumRotatedSortd {


    public static boolean pairSumRoatedArry(ArrayList list,int target) {        //O(n)
        
        int rotatedpoint=0;     // rotated point where array is rotated

        for(int i=0; i<list.size()-1;i++){

            if ((int)list.get(i)>(int)list.get(i+1)) {   //ex: 15>3
                rotatedpoint=i;
                break;
            }
        }

        int lp=rotatedpoint+1;        //left pointer 
        int rp=rotatedpoint;      //right pointer

        while (lp!=rp) {
            
            if ((int)list.get(lp)+(int)list.get(rp)==target) {
                return true;
            }
            else if ((int)list.get(lp)+(int)list.get(rp) > target) {
               
                rp=(rp+list.size()-1)%list.size();      //imp 
            }else
                lp=(lp+1)%list.size();                  //imp

        }



        return false;
    }


    public static void main(String[] args) {
        
        ArrayList<Integer> list=new ArrayList<>();      //if list is sorted given 

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(pairSumRoatedArry(list,16));
    }
}

/*
 * [11,15,  3,4,5,6]
 *      rp  lp
 * 
 * 15+3=18 18>16
 * 
 * imp modulo arithmetic formula
 * 
 * lp=(lp+1)%n;
 * rp=(rp+n-1)%n;
 */
