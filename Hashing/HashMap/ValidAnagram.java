import java.util.HashMap;

public class ValidAnagram {
    
    public static boolean isValidAnagram(String s1,String s2){

        if (s1.length()!=s2.length()) {
            return false;
        }

        HashMap<Character,Integer> cfeqmap = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            cfeqmap.put(ch,cfeqmap.getOrDefault(ch, 0)+1); // if duplicate charcter are exits...  ex: a :3,  b :2
        }

        for (char ch : s2.toCharArray()) {
            
            if (cfeqmap.containsKey(ch)) {
                
                if (cfeqmap.get(ch)==1) {   // if freq. is 1 then remove out
                    cfeqmap.remove(ch);
                }else
                cfeqmap.put(ch,cfeqmap.get(ch)-1);   //else reduce by one...
            
            }else
                return false;  // not presnet then retune false
        }

        return cfeqmap.isEmpty();   // if empty then true otherwise false
    }

    public static void main(String[] args) {
        
        System.out.println(isValidAnagram("race", "care"));
    }
}
