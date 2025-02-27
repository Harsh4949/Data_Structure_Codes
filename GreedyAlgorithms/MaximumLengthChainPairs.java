package GreedyAlgorithms;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MaximumLengthChainPairs {
    
    public static int findMaxLenChainPair(int []pairpart1,int[]pairpart2){// O(nlogn)

        //we need to sort as per pair 2nd value

        int soetedpair[][]=new int[pairpart1.length][2];

        for (int i = 0; i < pairpart1.length; i++) {
            soetedpair[i][0]=pairpart1[i]; //1st pair elemnt
            soetedpair[i][1]=pairpart2[i]; //2nd pair elemnt
        }

        //sort

        Arrays.sort(soetedpair,Comparator.comparingDouble(o->o[1]));

        //pair1 pair2
        //(a,b) (c,d)
        int maxPair=1;
        int lastElement=soetedpair[0][1];
        System.out.println("("+soetedpair[0][0]+(",")+soetedpair[0][1]+")");

        for (int i = 1; i < soetedpair.length; i++) {
            
            int startpairEle=soetedpair[i][0];

            if (lastElement<=startpairEle) {  //( b<+=c)
               
                 maxPair+=1;
                System.out.println("("+startpairEle+(",")+soetedpair[i][1]+")");
                lastElement=soetedpair[i][1];
            }
        }


        return maxPair;
    }

    public static void main(String[] args) {
        
        int[] pairpart1={5,39,5,27,50};
        int[] pairpart2={24,60,28,40,90};

        System.out.println(findMaxLenChainPair(pairpart1, pairpart2));
    }
}
