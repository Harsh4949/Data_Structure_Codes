package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQInJCF {

    public static void main(String[] args) {

        PriorityQueue<Integer>pq = new PriorityQueue<>(); // low element have high priority
        PriorityQueue<Integer>pq2 = new PriorityQueue<>(Collections.reverseOrder());   // prority will reversed 
                                                                                    // high element have high priority

        pq.add(10);   // order of inserting not mattter delet the element have highest pririty
        pq.add(3);
        pq.add(15);
        pq.add(2);
        

        pq2.add(10);   // order of inserting not mattter delet the element have highest pririty
        pq2.add(3);
        pq2.add(15);
        pq2.add(2);
 
        System.out.println(pq.peek());                //2
        System.out.println(pq.remove()+" : removed");   //2 : removed
        System.out.println(pq.peek());                  //3

        System.out.println(pq2.peek());                //15
        System.out.println(pq2.remove()+" : removed");   //15 : removed
        System.out.println(pq2.peek());                  //10

        System.out.println("Asending order");
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

        System.out.println("Desending order");
        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek());
            pq2.remove();
        }
    }
}

/*
 * 
 * A Priority Queue :  is a special type of *queue where elements are dequeued based
                    * on their priority* rather than the order in which they were enqueued*. 
 * 
 */
