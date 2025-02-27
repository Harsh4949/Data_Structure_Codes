package GreedyAlgorithms;

import java.sql.Array;
import java.util.Arrays;

public class LexicographicallySmallestString {
    
    public static void lexicographicallySmallestString(int N,int K){

        char[]lexiSmall=new char[N];

        // fill it by  a 
        Arrays.fill(lexiSmall, 'a');  //[a,a,a,a,a]= 5

        K-=N;  //coz now  5 time fill in lexiSmall aary.

        for(int i=N-1;i>=0 ;i--){   // now we change the values of element form last
    
            if (K<=0) break;

            int addMaxChar=Math.min(K, 25);    // 0,25 alphbates not used 1-26 coz we add a 
            lexiSmall[i]=(char)(addMaxChar+'a');
            K-=addMaxChar;

        }


        for (char c : lexiSmall) {
            System.out.print( " "+c);
        } 

        System.out.println();
    }
    
    public static void main(String[] args) {
        
        lexicographicallySmallestString(5, 42);
        lexicographicallySmallestString(3, 25);

    }
}
