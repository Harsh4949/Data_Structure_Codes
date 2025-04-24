package DynamicProgramming.Type_3;
import DynamicProgramming.Type_2.*;

public class StringConversion {

    //Convert Str1 to Str2 With Only Insertion And Deletion.
    // 1: Find length Of Str1 And Str2 
    // 2. Find length Of LCS of Str1 And Str2 
    // 3. subtract LCSLen form Str1 == No. of deletion Char reqire
    // 4. subtract LCSLen form Str2 == No. of Insertion Char reqire
    // 5. Total No of Opration = No. of deletion Char reqire + No. of Insertion Char reqire

    public static int stringConversionTab(String str1 ,String str2) {
 
        int n=str1.length(), m=str2.length();
        int dp[][]= new int[n+1][m+1];

        //Find LCS

        //Initialize


        for (int i = 1;i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                
                if (str1.charAt(i-1)==str2.charAt(j-1)) {
                    
                    dp[i][j]=dp[i-1][j-1]+1;

                } else {
                    
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcsLen=dp[n][m];

        int delOp=n-lcsLen;     //str1 Length
        int insOp=m-lcsLen;     //str2 Length
        
        System.out.println("Deletion operation  : "+delOp +"\nInsertion operation : "+insOp);

        a0_1Knapsack.print(dp);
        return delOp+insOp;
    }

    public static void main(String[] args) {
        
        String str1="pear";
        String str2="sea";

       // System.out.println(stringConversionTab(str1, str2));
        System.out.println(stringConversionTab("abcdef", "abcg"));
    }
}
