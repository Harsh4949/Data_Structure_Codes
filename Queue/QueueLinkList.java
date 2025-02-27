package Queue;


public class QueueLinkList {
   
    static class Node {
    
        int data;
        Node next;

        public Node(int data){
             this.data=data;
        }
    }

    static class Queue {
    
        public static Node head=null;
        public static Node tail=null;

        public boolean isEmpty(){

            return head==null &&tail==null;
        }

        public void add(int data){

            Node newNode=new Node(data);

            if (head==null) {
                head=tail=newNode;
                return;
            }

            tail.next=newNode;
            tail=newNode;
        }

        public int remove(){

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int data=head.data;

            if (head==tail) {
                head=tail=null;
            }
            else
                head=head.next;

            return data;
        }

        public int peek(){

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }


    }

    public static void main(String[] args) {
        
        Queue q=new Queue();

        q.add(10);
        q.add(10);
        q.add(10);
        q.add(10);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        q.add(20);
        q.add(20);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

}
