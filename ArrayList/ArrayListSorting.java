package ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class ArrayListSorting {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int arr[]={10,5,3,7,8};

        list.add(10);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(8);

        System.out.println(list);
        Collections.sort(list); // asending order sort

        Arrays.sort(arr);       //for sorting aary

        System.out.println(list);

        Collections.sort(list,Collections.reverseOrder());  // desending reverseorder

        System.out.println(list);

    }
}
