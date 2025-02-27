
import java.util.HashMap;

public class HashMapJCF {

    public static void main(String[] args) {
        
        HashMap<String,Integer> hm= new HashMap<>();

        
        hm.put("China",150);  //  add O(1)
        hm.put("India",100);
        hm.put("Dubai",70);
        hm.put("USA",50);

        System.out.println(hm);

        hm.put("India",110);
        System.out.println(hm);

        System.out.println(hm.containsKey("India"));  //O(1)
        System.out.println(hm.containsValue(150));

System.out.println();
        System.out.println(hm.get("India"));    // get O(1)
        System.out.println(hm.get("UK"));
System.out.println();

        System.out.println(hm.size());


        System.out.println();
        System.out.println(hm.remove("USA"));  // remove O(1)
        System.out.println(hm);

System.out.println();
        System.out.println(hm.isEmpty());
        hm.clear();
        System.out.println(hm.isEmpty());



        
    }
}
