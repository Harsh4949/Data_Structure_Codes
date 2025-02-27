package Backtracking;

import Stringque.replaceWithString;

public class gridwaysSrcToDest {
    
    public static int countGridwaysSrcToDest(int i,int j,int m,int n){      // O(2^n+m)--> witch is not good exponential

        //base condition 

        if (i==n-1 ||j==m-1) {          //when rich to before target element
            return 1;
        }
        if (i==m||j==n) {            //when rich to boundry
            return 0;
        }

        //recurtion

        int w1=countGridwaysSrcToDest(i, j+1, m, n); // for right move
        int w2=countGridwaysSrcToDest(i+1, j, m, n); // for down move

        return w1+w2;

    }

    public static int fact(int n){

        if (n==1) {
            return 1;
        }

        return n*fact(n-1);
    }

    public static int countGridwaysSrcToDestLinear(int i,int j,int m,int n){

        int upperpart =fact((n-1)+(m-1));
        int lowerpart =fact(n-1)*fact(m-1);

        return upperpart/lowerpart;

    }


    public static void main(String[] args) {
        
        int n=3,m=3;//targert
                                                    //src
        System.out.println(countGridwaysSrcToDest(0, 0, m, n));
        System.out.println(countGridwaysSrcToDestLinear(0, 0, m, n));
    }
}


/*  we can also do this using the formula of permutation...

    which is  (n-1+m-1)!
            -------------
            (n-1)! * (m-1)!

    where we check the combination of RD ->RRDD

*/ 