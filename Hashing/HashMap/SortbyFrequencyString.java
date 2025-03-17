import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortbyFrequencyString {

    public static String sortByFrequnecy(String str){

        StringBuilder result =new StringBuilder();


       // Step 1: Count character frequencies

        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max heap to sort characters by frequency

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(  // use if sorting done woth hashmaps
            (a, b) -> b.getValue() - a.getValue()  // asending order
        );

        maxHeap.addAll(freqMap.entrySet());

        // Step 3: Build the result string

        while (!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();
        
            // Append the character 'freq' times using a loop
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }


        return result.toString();

    }
    
    public static void main(String[] args) {
        
        System.out.println(sortByFrequnecy("cccaaa"));
        System.out.println(sortByFrequnecy("tree"));
    }
}

/*
 * 
 * 
 *  
        Sample Input 1 : s = "cccaaa" 
        Sample Output 1 : "aaaccc" 
        Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers. 
        Note that "cacaca" is incorrect, as the same characters must be together. 
        
        Sample Input 2 : s = "tree" 
        Sample Output 2 :"eert" 
        'e' appears twice while 'r' and 't' both appear once. 
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */