package DynamicProgramming.Type_3;

public class WildcardMatching{

    public static boolean IsMatch(String s,String p){  // s - String , P = Pattern

        int n=s.length()+1;
        int m=p.length()+1;
        boolean dp[][]=new boolean[n][m];

        //initialize
        
        // if S==P= " "= True
        dp[0][0]=true;


        // if s"abc" and p=" " then s is not maching with p so it false 

        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=false;
        }

        // if the string is Empty s=" ", p "abc" then it would be false
        
        for (int j = 1; j < dp.length; j++) {

            dp[0][j]=dp[0][j-1]; // if previous seq. of char retun true then true otherwise false
        }



        return dp[n][m];
    }

    public static void main(String[] args) {
        
        String
    }
}
