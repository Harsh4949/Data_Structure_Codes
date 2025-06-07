package DynamicProgramming.Type_3;
import DynamicProgramming.Type_2.*;

public class WildcardMatching{

        public static void print(boolean[][] dp) {
        int i=0;
        for (boolean[] is : dp) {
            System.out.print("i="+(i++)+" |");
            for (boolean is2 : is) {
                System.out.print(is2+" |");
            }
            System.out.println();
        }
    }

    public static boolean IsMatch(String s,String p){  // s - String , P = Pattern

        int n=s.length()+1;
        int m=p.length()+1;
        boolean dp[][]=new boolean[n][m];

        //initialize
        
        // if S==P= " "= True
        dp[0][0]=true;


        // if s"abc" and p=" " then s is not maching with p so it false 

        for (int i = 1; i < n; i++) {
            dp[i][0]=false;
        }

        // if the string is Empty s=" ", p "abc" then it would be false
        
        for (int j = 1; j <m; j++) {
            if(p.charAt(j-1)=='*')
                 dp[0][j]=dp[0][j-1]; // if previous seq. of char return true then true 
            
            //else otherwise false dp[0][j]=false;
        }

        for (int i = 1; i < n; i++) {       //s --row
            for (int j = 1; j < m; j++) {      //p -- column
                
                // Condition 1 : if Both char is equal Or '?' :- able to replace 1 character
                
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                    dp[i][j]=dp[i-1][j-1]; // if previous true then now it is aslo true
                }

                // condition 2 : if '*' is encountered
                // then ignore  : dp[i][p-1]
                // then keep  : dp[i-1][p]
                // if any one retun true then true

                else if(p.charAt(j-1)=='*'){

                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }

                else{

                    dp[i][j]= false; // not reqire in java
                }
            }
        }


        print(dp);
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {   // see Dry RUN At 3 feb 2025 NootBook
        
        String text="abc",pattern="**?b*"; //ex=1 
        String text1="aa",pattern2="*"; //ex=2 
        String text3="baaabab",pattern3="a*ab"; //ex=3 

        System.out.println(IsMatch(text,pattern));
        System.out.println();
        System.out.println(IsMatch(text1,pattern2));
        System.out.println();
        System.out.println(IsMatch(text3,pattern3));
    }
}
