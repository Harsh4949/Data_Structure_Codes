package DynamicProgramming.Type_3;

public class LCS {      //Longest Common Subsequence 
    
    public static int LCS(String str1,String str2,int n,int m) { // See Logic in LCSLogic.png image
        
        if (n==0 || m==0) {
            return 0;
        }

        if (str1.charAt(n-1)==str2.charAt(m-1)) { 
            // if last two char are same then reduce the size of String By 1
            //And Add 1 in Answer 
            return LCS(str1, str2, n-1, m-1)+1;
        } else {
            // if not same then Make Two Call bye Redusing size bye Each One
            return Math.max(LCS(str1, str2, n-1, m), LCS(str1, str2, n, m-1));  
        }
    }

    

    public static void main(String[] args) {
        
        String str1="abcde";
        String str2="ace";

        System.out.println(LCS(str1, str2, str1.length(), str2.length()));
    }
}
