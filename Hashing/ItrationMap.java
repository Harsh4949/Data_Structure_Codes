package Hashing;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItrationMap {
    

    public static void main(String[] args) {
        
        HashMap<String,Integer> map= new HashMap<>();


        map.put("China",150);  //  add O(1)
        map.put("India",100);
        map.put("Dubai",70);
        map.put("USA",50);

        Set<String> keys = map.keySet();

        Set<Map.Entry<String, Integer>> values= map.entrySet();

        System.out.println(values);

        System.out.println(keys);

        System.out.println();
        for (String str : keys) {
            System.out.println("Key : "+str+"\t Value : "+map.get(str));
        }
    }
}
