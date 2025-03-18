import java.security.KeyStore.Entry;
import java.util.*;

class LRUCache {

    LinkedHashMap<Integer,Integer> cache;
    int capacity=0;
    public LRUCache(int capacity) {
        
        this.capacity=capacity;

        cache= new LinkedHashMap<Integer,Integer>(capacity,0.75f,true); // true add the resently get or put value at last

        // {  - also use this method (this method invoke before every put function)
        
        //     @Override
        //     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        //         return size() > capacity; // Remove least() recently used which is in 1st element in mp. if cache is full
        //     }
        // }; 

    }

    public int get(int key) {
        
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        
          
        if (cache.containsKey(key)) {
            cache.put(key, value); // Update existing key (moves it to most recently used)
            return;
        }

        if (cache.size() >= capacity) {
            
            int firstKey = cache.keySet().iterator().next(); // Find LRU key (first in LinkedHashMap)

            cache.remove(firstKey); // Remove LRU key
        }

        cache.put(key, value); // Insert new key-value pair

    }
}


public class LRUCacheimpliment {
    
   public static void main(String[] args) {
    
        LRUCache obj = new LRUCache(2);

        obj.put(1, 10);
        obj.put(2, 20);

        System.out.println(obj.get(2));

        System.out.println(obj.cache);  
        obj.put(3, 30);

        System.out.println(obj.cache);  
    }
}

 
 /*
  * 
  How Load Factor Works?
        -If loadFactor = 0.75, the map resizes when it is 75% full.
        -If loadFactor = 0.5, it resizes when it is 50% full.

        When resizing, the number of buckets doubles.

        if (size >= capacity * loadFactor) {
            resize(); // Doubles the capacity
        }
  */

  // https://chatgpt.com/share/67d944a3-e4cc-8008-adb4-1bdf83f3c029