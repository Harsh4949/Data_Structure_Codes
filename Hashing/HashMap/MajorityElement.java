
import java.util.*;

public class MajorityElement {

    public static void main(String[] args) {
        
        int arr[]={1,3,2,1,4,1,2,1,1}; // we need to retun the elemt that have frequncy grater than N/3

        HashMap<Integer,Integer> fmap= new HashMap<>();

        for (int i : arr) {
            
            // if (fmap.containsKey(i)) {
            //     fmap.put(i, fmap.get(i)+1); // update the value
            // }else
            //     fmap.put(i, 1);    // insert 1 if 1st time encountered

            fmap.put(i, fmap.getOrDefault(i, 0)+1); // this return the value present at given key 
                                                                //else return default value that er given in this case 0

            // 1 : 1-> 2 -> 3 ->4
            // 2 : 1  etc..
        }

        for (Integer i : fmap.keySet()) {
            
            if (fmap.get(i)>arr.length/3) {
                System.out.println(" "+i);
            }
        }
    }
    
}