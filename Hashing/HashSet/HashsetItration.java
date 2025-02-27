import java.util.*;

public class HashsetItration {
    
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();  

        set.add(10);
        set.add(5);
        set.add(2);
        set.add(10);

        // there are two ways to itrate the Set 

        // using for each loop

        for (Integer integer : set) {
            System.out.println(integer);
        }

        //using Itrator

        Iterator i = set.iterator();  // it retuen the itrator

        while (i.hasNext()) { // check nect elemnt it there or not 
            
            System.out.println(i.next());// by defult it pointed to null . so it print the next elemt and go i= i->next
        }

    }
}