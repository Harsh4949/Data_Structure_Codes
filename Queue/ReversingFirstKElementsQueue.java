package Queue;

import java.util.*;

public class ReversingFirstKElementsQueue {
    
    public static void reverseKElements(Queue<Integer> q,int k){   //1st Approch O(n)  O(n)

        if (q.isEmpty() || k>q.size()) {

            System.out.println("-1");
            return;
        }

        //get a first k Elements in Stack

        Stack<Integer> s=new Stack<>();

        for(int i=0;i<k;i++)
            s.push(q.poll());

        //add the elemts of stack in queue

        while (!s.isEmpty()) 
            q.add(s.pop());
        

        //remove starting elemts of queue and add it in last

        int n=q.size()-k;

        for(int i=0;i<n;i++)
            q.add(q.poll());

    }

    public static void reverseKElements2(Queue<Integer> q,int k){   //2nd Approch O(n)  O(n)

        helper(q, k);

         //remove starting elemts of queue and add it in last

         int n=q.size()-k;

         for(int i=0;i<n;i++)
             q.add(q.poll());
    }

    public static void helper(Queue<Integer> q,int k) {
        
        if (k==0) {     //base condition
            return;
        }

        //recuesion

        int n=q.poll(); //
        helper(q, k-1); // 10 20 30 40 50 
        q.add(n); // reverse the elemet and put it on end of the queue.  // 50 40 30 20 10 exit 

    }


    public static void main(String[] args) {
        
        Queue<Integer> queue=new LinkedList<>();
        int k=5;

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        reverseKElements2(queue, k);

        while (!queue.isEmpty()) {
            System.out.print(" "+queue.poll());
        }


    }
}

/*
 * 
 * Sample Input 1 : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] ,k=5 
   Sample Output 1 : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
 * 
 * 
 * 
 */