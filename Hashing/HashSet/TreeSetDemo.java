import java.util.*;

public class TreeSetDemo {
    
    public static void main(String[] args) {
        
        TreeSet<String> set = new TreeSet<>();  // Implimented by TreeMap (Red-Black tree)
                                                // all Uniqe values are stored like Hashmap Keys 
                                                //, Null Not allowd to store
                                                 // O(1) for all functions

        set.add("Kolhapr"); // Inserd as per the sorting Order(asending)
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
