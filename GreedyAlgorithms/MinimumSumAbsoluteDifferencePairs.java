package GreedyAlgorithms;

import java.sql.Array;
import java.util.Arrays;

public class MinimumSumAbsoluteDifferencePairs {
    

    public static int findMinimumAbsoluteDiff(int[]A,int[]B){

        int absoluteDiff=0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length; i++) {
            
            absoluteDiff+=Math.abs(A[i]-B[i]);
        }

        return absoluteDiff;
    }

    public static void main(String[] args) {
        
        int A[]={4,1,8,7};
        int B[]={2,3,6,5};

        int a[]={1,2,3};
        int b[]={3,2,1};

        System.out.println(findMinimumAbsoluteDiff(A, B));
        System.out.println(findMinimumAbsoluteDiff(a, b));
    }
}
