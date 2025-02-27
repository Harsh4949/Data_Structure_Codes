package Queue;

import java.util.*;


public class ReverseQueue {
    
    public static Queue<Integer> q=new LinkedList<>();

    public static void reverseQueue(){

       
        Stack<Integer> s=new Stack<>();

       while(!q.isEmpty()){ // to insert the elements in stack.
            s.push(q.remove());
        }

        while (!s.isEmpty()) { // to insert back elements in stack to Queue.
            q.add(s.pop());
        }


    }



    public static void main(String[] args) {
        
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);      // 10 20 30 40 50 

        reverseQueue();

        while (!q.isEmpty()) {
            System.out.println(q.remove());     //output Must : 50 40 30 20 10 if it reversed
        }

    }
}
