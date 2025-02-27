package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;;

public class QueueJFC {
    

    public static void main(String[] args) {
        
        Queue<Integer>q1= new ArrayDeque<>();
        Queue<Integer>q2= new LinkedList<>();

        q1.add(12);
        System.out.println(q1.peek());
    }
}


/*
 * what is arraydeque and linked list while implementing queue in java : https://chatgpt.com/share/67952ff5-27b0-8008-8bb8-f153dd9adf25
 * 
 * 1. Internal Implementation
        ArrayDeque:
                -Uses a dynamically resizing array internally.
                -Elements are stored in a contiguous block of memory.
        LinkedList:
                -Uses a doubly-linked list internally.
                -Each element is a node containing data and references to the previous and next nodes.


    Key Takeaways:
            - Choose ArrayDeque for better performance and lower memory overhead when implementing a queue.

            - Choose LinkedList if you specifically need to store null elements 
               or if linked structure benefits your use case (rare for queues).
    

 */
