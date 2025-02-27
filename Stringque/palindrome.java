package Stringque;

public class palindrome {

    public static boolean checkpalindrome(String str){

        for(int i=0;i<=str.length()/2;i++){         //O(n)
            
            if (str.charAt(i)!=str.charAt(str.length()-i-1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkpalindrome("madam"));
    }
}
