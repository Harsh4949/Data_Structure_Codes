package Queue;

import java.util.*;

public class MaximumAllSubarraysSizeKSlidingWindow {
    
    public static int[] printMaximumAllSubarraysSizeK(int[] arr,int k){

        Deque<Integer> queue=new LinkedList<>();
        
        int []sol=new int[arr.length-k+1];

        int j=0;
        //1st add the 1st window of k elemnts
        //while adding remove all the elemts less than that elements

        for(int i=0;i<k;i++){
                                                    //grater element from rear 
            while (!queue.isEmpty()&& arr[i]>=arr[queue.peekLast()]) {
                queue.removeLast();  //remove form rear                             if 1 2 and cur=3 then we campre 3>=2 then remove 2 same fro 1
            }
            queue.addLast(i);       //add from rear
        }
        
        System.out.println("Output of First Window : "+arr[queue.peek()]);
        sol[j++]=arr[queue.peek()];


        //1st window loded with grater element now only we need to cehck

        // here we need to slide the window one by one
        //and then->while adding remove all the elemts less than that elements

        for(int i=k;i<arr.length;i++){

                                                        //dq=6,5,4,3 now need to move the slide so remove 6 index of 6 is 0
            System.out.println(queue.peek()<=i-k);
            System.out.println(queue.peek()+"<="+(i-k));
                                        //  0<=4-4=0 so remove 6 goes to next window
                                        //  1<=5-4=1 so remove 6 goes to next window  this is for removing 5 of index 1
             while (!queue.isEmpty()&& queue.peek()<=i-k) {         //to slide the window...
                 queue.removeFirst();       //remove the fornt elemnt
             }
            
            while (!queue.isEmpty()&& arr[i]>=arr[queue.peekLast()]) {

                queue.removeLast();  //remove form rear
            }

            queue.addLast(i);       //add from rear
             
            System.out.println("Output of "+j+" Window : "+arr[queue.peek()]);
            sol[j++]=arr[queue.peek()];
        }
        

        return sol;
    }


    public static void main(String[] args) {

        Queue<Integer> queue=new LinkedList<>();
        int k=3;

      //  int []arr={ 1, 2 ,3 ,1 ,4 ,5 ,2 ,3, };
      int []arr={ 6,5,4,3,2,1 };        //take this example considerration whenever do thsi problem

        int []sol=printMaximumAllSubarraysSizeK(arr, k);


        for (int i : sol) {
            System.out.println(i);
        }

    }
}

// "E:\Sigma 3.0\live dout session\31.Practice Session 25 - (16_07_24).mp4"