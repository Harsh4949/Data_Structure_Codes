package Queue;

import Stringque.replaceWithString;

public class QueueArray {

    static class Queue {
        
        private int[] queue;
        private int front;
        private int rear;

        Queue(int size){

            queue=new int[size];
            front=0;
            rear=-1;
        }

        public  boolean isEmpty(){

            return rear==-1;
        }

        public void enQueue(int data){

            if (rear==queue.length-1) {
                System.out.println("Queue is full...");
                return;
            }

            rear+=1;

            queue[rear]=data;
        }

        public int deQueue(){

            if (isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }

            front=queue[0];

            for(int i=0;i<rear;i++){

                queue[i]=queue[i+1];
            }

            rear=rear-1;
            return front;
        }

        public void print(){

            for (int i=0;i<=rear;i++) {
                System.out.println(queue[i]);
            }
        }
            
    }

    public static void main(String[] args) {
        
        Queue q=new Queue(5);

        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);

        q.deQueue();
        q.deQueue();
        q.deQueue();

        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);

        q.print();
        

    }
}
