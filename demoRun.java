import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class demoRun {

    public static void main(String[] args) {
        

        int [] arr = {-3, 0, 2, 1};

        Arrays.sort(arr);
        int pSum=0;

        for (int i=arr.length-1;i>=0;i--) {
            pSum+=arr[i];
            System.out.print(" "+pSum);
        }

    }
    
}
