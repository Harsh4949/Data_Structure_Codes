package Backtracking;

public class KeypadCombination {

    static char[][] keypad = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'}, 
    {'j','k','l'},{'m','n','o'},{'p','q','r','s'}, 
    {'t','u','v'},{'w','x','y','z'}}; 
    
   

    public static void findKeypadCombination(String digit,int i,int len,StringBuilder str) {
       
        if (len==0) {
            System.out.println("null");
            return;
        }

        if (i==len) {
            System.out.println(str.toString());
            return;
        }


        char []letter = keypad[Character.getNumericValue(digit.charAt(i))];

        for(int j=0;j<letter.length;j++){
            findKeypadCombination(digit, i+1, len, new StringBuilder(str).append(letter[j]));
                                                    // it act as string append (+)
        }
    }

    public static void main(String[] args) {
        
        String digit ="23";

        //we use String also 
        findKeypadCombination(digit, 0, digit.length(), new StringBuilder());

    }
}
