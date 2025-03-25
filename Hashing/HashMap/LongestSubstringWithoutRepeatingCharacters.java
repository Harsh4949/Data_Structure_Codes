import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    

    public static int lengthOfLongestSubstring(String s) {
        
        int maxWlen=0;
        HashMap<Character,Integer> map= new HashMap<>();
        int left=0;

        for(int right=0; right<s.length() ;right++){
            char curCh=s.charAt(right);
            int last=map.getOrDefault(curCh,-1);

            if(last>=left){        //the window is dynamic chage as per condition 
                left=last+1;
            }

            map.put(curCh,right);
            maxWlen=Math.max(maxWlen,right-left+1);   // why right-left+1 // ex [10,15]  10-15+1 = 5 window size
        }

        return maxWlen;
    }

    public static void main(String[] args) {
        // consider this example for dry run and making conditions 
 
        System.out.println(lengthOfLongestSubstring("abcdbaxb"));
        // abcdbaxb
        // l-->r

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
