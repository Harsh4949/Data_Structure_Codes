

import java.util.*;
public class LinkedHashMapDemo {
    

    public static void main(String[] args) {
        
        LinkedHashMap<String,Integer> lhm= new LinkedHashMap<>(); // O(1) for all functions And Arry Of DoublyLinkedList is used 

        HashMap<String,Integer> hm= new HashMap<>();  // O(1) for all functions And Arry Of LinkedList is used 

        hm.put("Harsh", 4);   // insert in Random order
        hm.put("Raj", 5);
        hm.put("Parth", 6); 


        lhm.put("Harsh", 4);   // insert as per the order of puting
        lhm.put("Raj", 5);
        lhm.put("Parth", 6); 

        System.out.println(hm+" : Random order Insertd , LinkedList DS used.");
        System.out.println(lhm+" : Insertd as per Order of Putting , DoublyLinkedList DS used.");

    }
}
