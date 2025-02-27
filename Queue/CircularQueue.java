package Queue;

public class CircularQueue {
    
    static class Queue {
        
        private int[] queue;
        private int front;
        private int rear;

        Queue(int size){

            queue=new int[size];
            front=-1;
            rear=-1;
        }

        public  boolean isEmpty(){

            return rear==-1 && front==-1;
        }

        public  boolean isFull(){

            return (rear+1)%queue.length==front;
        }

        public void enQueue(int data){

            if (isFull()) {
                System.out.println("Queue is full...");
                return;
            }

            if (rear==-1) {
                front=0;
            }

            rear=(rear+1)%queue.length;

            queue[rear]=data;
        }

        public int deQueue(){

            if (isEmpty()) {
                System.out.println("Queue is Empty...");
                return -1;
            }

            
            int n=queue[front];
            

            if (rear==front) {
                rear=front=-1;
            }else

                front=(front+1)%queue.length;
            
            return n;
        }

        public void print(){

            if (!isEmpty()) {
                
            
            if (rear<front) {
                    
                for(int i=0;i<=rear;i++){
                    System.out.print(" "+queue[i]);
                }

                for(int i=front;i<queue.length;i++){
                    System.out.print(" "+queue[i]);
                }
            }

            for (int i=front;i<=rear;i++) {
                System.out.print(" "+queue[i]);

            }
        }
        }
            
    }

    public static void main(String[] args) {
        
        Queue q=new Queue(5);

        q.enQueue(1);
        q.enQueue(3);
        q.enQueue(5);
        q.enQueue(7);
        q.enQueue(10);
        
        q.print();System.out.println();

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    

        q.enQueue(3);
        q.enQueue(5);


        q.print();
        
        }
}
