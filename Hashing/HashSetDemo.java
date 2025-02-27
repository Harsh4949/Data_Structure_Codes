import java.util.*;

public class HashSetDemo {
    

    public static void main(String[] args) {
        
        HashSet<Integer> set = new HashSet<>();  // Implimented by HashMap
                                                 // all Uniqe values are stored like Hashmap Keys , Null allowd to store
                                                 // O(1) for all functions

        set.add(10);// random order stoerd
        set.add(5);
        set.add(2);
        set.add(10);

        System.out.println(set);

        set.remove(10);
        System.out.println(set);


        System.out.println(set.contains(5));
        System.out.println(set.size());
        set.clear();

    }
}
