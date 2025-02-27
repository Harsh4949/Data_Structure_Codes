package Heaps;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    
    static class Pair implements Comparable<Pair>{

        int val;
        int idx;

        public Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair p2){

            return p2.val-this.val;  // here we need max elemnt in slideing window
                                    //  so we create a Priority queue in Desending order

        }
    }

    public static void slideingWindow(int arr[],int k){

        int maxSlideWin[]=new int[arr.length-k+1]; // formula to find no. of Windows are formed 8-3+1 = 6 windows formes
    
        PriorityQueue<Pair> pq= new PriorityQueue<>();
       // int idx=1;
        // Load the 1st Window Of K elemnt in PQ
        
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // get the max value of 1st Window

        maxSlideWin[0]=pq.peek().val;   // PQ have always max value on top

        //Now load the 1 by 1 element in PQ.

        for (int i = k; i < arr.length; i++) {
            
            // remove the elemt that not Contian in window

            while (pq.size()>0 && pq.peek().idx<=(i-k)) {  // i-K is formula to see which elemnt not found in window EX: 1<=4-3 =1 remove 1
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));

            maxSlideWin[i-k+1]=pq.peek().val;  // to store the value in current window this also done by declare i=0 and give
            //   [idx++]
        }

       for (int i : maxSlideWin) { 
        System.out.print(" "+i);  // 3 3 5 5 6 7
       }
        
    }

    public static void main(String[] args) {
        
        int arr[]={1,3,-1,-3,5,3,6,7};

        int k=3;// window size

        slideingWindow(arr, k);
    }
}
