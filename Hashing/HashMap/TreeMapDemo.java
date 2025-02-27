import java.util.*;


public class TreeMapDemo {
    
    public static void main(String[] args) {
        
        TreeMap<String,Integer> thm= new TreeMap<>(); // O(logn) for all functions And Arry Of Red-Black Tree is used 

        HashMap<String,Integer> hm= new HashMap<>();  // O(1) for all functions And Arry Of LinkedList is used 

        hm.put("Ab", 4);   // insert as per the Sorted Order
        hm.put("Cd", 5);
        hm.put("Bf", 6); 


        thm.put("Ab", 4);   //insert as per the Key Sorted Order
        thm.put("Cd", 5);
        thm.put("Bf", 6); 

        System.out.println(hm+" : Random order Insertd , LinkedList DS used.");
        System.out.println(thm+" : Insertd as per Key soeted Order , Red-Black Tree DS used.");
    }
}

/*
 * 
 * {Ab=4, Cd=5, Bf=6} : Random order Insertd , LinkedList DS used.
{Ab=4, Bf=6, Cd=5} : Insertd as per Key soeted Order , Red-Black Tree DS used.
 */