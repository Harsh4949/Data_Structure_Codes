
import java.util.*;

public class LinkedHashSetDemo {
    
    public static void main(String[] args) {
        
        LinkedHashSet<String> set = new LinkedHashSet<>();  // Implimented by LinkedHashMap (Dobly LL)
                                                // all Uniqe values are stored like Hashmap Keys , Null allowd to store
                                                 // O(n) for all functions

        set.add("Kolhapr"); // Inserd as per the oder of inserting
        set.add("Sangli");
        set.add("Satara");
        set.add("Karad");

        System.out.println(set);

        set.remove("Karad");
        System.out.println(set);


        System.out.println(set.contains("Sangli"));
        System.out.println(set.size());
        set.clear();
    }
}
