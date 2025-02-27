package Queue;

import java.util.*;

public class QueueUsing2Stack {
    
    static class Queue {
    
        Stack<Integer> qMain=new Stack<>();
        Stack<Integer> q2=new Stack<>();


        public void add(int data){

            while (!qMain.isEmpty()) {
                q2.push(qMain.pop());
            }
            
            q2.push(data);

            while (!q2.isEmpty()) {
                qMain.push(q2.pop());
            }
        }

        public int remove(){

            if (qMain.isEmpty()) {
                System.out.println("Queue is Empty...");
                return  -1;
            }

            int front = qMain.pop();

            return front;
        }

        public int peek(){

            if (qMain.isEmpty()) {
                System.out.println("Queue is Empty...");
                return  -1;
            }

            int front= qMain.peek();

            return front;
        }
    }

    public static void main(String[] args) {
        
        Queue q =new Queue();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        q.remove();
        System.out.println(q.peek());
    }
}
