package LinkList;

public class ZigZagLinkedList {
    
    public class Node {
    
        int data;
        Node next;

        public Node(int data){

            this.data=data;
            this.next=null;
        }
    }

    public static Node head;

    public void addFirst(int data){

       Node newNode=new Node(data);

        if (head==null) {
            head=newNode;
            return;                 //don't forget
        }

        newNode.next=head;
        head=newNode;
    }
        
    public void print(){

        Node temp=head;
        if (temp==null) {
        System.out.println("List is empty");
        return;
       }
       
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }

        System.out.println("null");
    }

    public void createZigZag(){

        // find mid
        Node slow=head;
        Node fast=head.next;        // handle even situation

        while (fast!=null&&fast.next!=null) {  //handle even odd case of nodes
            
            slow=slow.next;     //+1
            fast=fast.next.next; //+2
        }

        //reverse linked list

        Node pre=null;
        Node cur=slow;  // slow is the mid element
        Node next;

        while (cur!=null) {
            
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }


        //create zigzag

        Node left =head;
        Node rigt=pre;
        Node lnext;
        Node rnext;

        while (left!=null && rigt!=null) {  // Deaw the LL for logic...
            
            lnext=left.next;
            rnext=rigt.next;

            left.next=rigt;
            rigt.next=lnext;

            left=lnext;
            rigt=rnext;
            
        }

        
    }
        

    public static void main(String[] args) {
        
        ZigZagLinkedList ll=new ZigZagLinkedList();

        ll.addFirst(40);
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addFirst(5);

        ll.print();

        ll.createZigZag();

        ll.print();
    }
}
