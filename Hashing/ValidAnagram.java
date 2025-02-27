import java.util.HashMap;

public class ValidAnagram {
    
    public static boolean isValidAnagram(String s1,String s2){

        if (s1.length()!=s2.length()) {
            return false;
        }

        HashMap<Character,Integer> cfeqmap = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            cfeqmap.put(ch,cfeqmap.getOrDefault(ch, 0)+1);
        }

        for (char ch : s2.toCharArray()) {
            
            if (cfeqmap.containsKey(ch)) {
                
                if (cfeqmap.get(ch)==1) {
                    cfeqmap.remove(ch);
                }else
                cfeqmap.put(ch,cfeqmap.get(ch)-1);
            
            }else
                return false;
        }

        return cfeqmap.isEmpty();
    }

    public static void main(String[] args) {
        
        System.out.println(isValidAnagram("race", "care"));
    }
}
