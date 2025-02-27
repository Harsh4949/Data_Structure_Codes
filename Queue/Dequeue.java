package Queue;

import java.util.*;

public class Dequeue {
    
    static class stackUdinDeuqueue{

        Deque<Integer> dq=new ArrayDeque<>();

        public void dequeueOprations(){

            dq.addLast(10);       // when we tell add last it add in rear
            dq.addLast(10);
            dq.addFirst(20);    // when we tell add last it add in front  remaimber First-Front
            dq.addFirst(20);
            dq.addFirst(20);        

            // dq.removeFirst();    // when we tell remove first it remove in front
            // dq.removeLast();     // when we tell remove last it remove in rear

            System.out.println( " getlast : "+dq.getLast()); 
            System.out.println( " getFist : "+dq.getFirst());    
            // dq.getLast();


            for (Integer i : dq) {
            System.out.println(i);
            }
            
            System.out.println(" peek :-"+dq.peek());
            System.out.println(" peek Last :-"+dq.peekLast());

        }
    }


    public static void main(String[] args) {
        
        stackUdinDeuqueue s1=new stackUdinDeuqueue();

        s1.dequeueOprations();

        
    }
}
