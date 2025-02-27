package Backtracking;

public class StringPermutation {
                                      //c          //abc
                                      //bc         //ab
                                      //abc        //a
    public static void findPermutation(String str,String ans) {
        
        //base Case
        if (str.length()==0) {
            
            System.out.println(ans);
            return;
        }

        //recurtion         -->O(n*n!)

        for(int i=0;i<str.length();i++){

            char curch=str.charAt(i);

            //to elimte the one by one character like //bc
            String newString = str.substring(0, i)+str.substring(i+1); //-> goes i+1 to N-1

            findPermutation(newString, ans+curch);
        }
    }

    public static void main(String[] args) {
        
        String str ="abc";

        findPermutation(str, "");
    }
}
