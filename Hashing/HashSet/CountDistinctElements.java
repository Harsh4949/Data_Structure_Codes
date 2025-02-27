import java.util.HashSet;

public class CountDistinctElements {

    public static void main(String[] args) {
        
        int arr[]={2,5,3,6,2,1,7,9,4,2};
        
        HashSet<Integer> set =new HashSet<>();

        for (int integer : arr) { //O(n)
            set.add(integer);
        }

        System.out.println("size of arr : "+ arr.length);
        System.out.println("Number of Distinct Values : "+set.size());
    }
}
