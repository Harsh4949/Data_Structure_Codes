package LinkList;


public class MergeSortInLL {

    public class Node {
        
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
 
    
    public void addFirst(int data){     //O(1)

        Node newNode = new Node(data);

        //check wheter it is first node
        if (head==null) {
            
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }


    public void print(){

        //Check Whether it Empty or not
        Node temp =head;

        while (temp!=null) {        //10->10->10->20->temp->>null
            
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    public Node getMid(Node head){  // like si-di in Merge sort

        Node slow=head;
        Node fast=head.next;    //imp to find the middle node at odd No. of nodes case in LL

        while (fast!=null&&fast.next!=null) {

            slow=slow.next;         //+1
            fast=fast.next.next;    //+2
        }

        return slow;
    }

    public Node mergeSort(Node head){
        
        if (head == null || head.next == null) { // Base case: single node or empty list then list is sorted itself
            return head;
        }

        Node mid=getMid(head);      // next goes to left or right subpart to mid..

        Node right=mid.next;    //left as node mid+1 as right
        mid.next=null;          // disconnect the linking

        //recursion
        Node newleft=mergeSort(head);
        Node newright =mergeSort(right);

        //backtracking
        return merge(newleft,newright);
    }

    public Node merge(Node headR,Node headL){

        Node mergeLL=new Node(-1); // dummy node for linking
        Node temp= mergeLL;

        while (headR!=null&&headL!=null) {
            
            if (headR.data<=headL.data) {
                
                temp.next=headR;
                headR=headR.next;

            }else{

                temp.next=headL;
                headL=headL.next;
            }
            temp=temp.next; //common
        }

        while (headR!=null) {
            
            temp.next=headR;
            headR=headR.next;
            temp=temp.next;
        }

        while (headL!=null) {
            temp.next=headL;
            headL=headL.next;
            temp=temp.next;
        }

        return mergeLL.next;  // -1 dummy node eliminated
    }
    
    public static void main(String[] args) {
        
        MergeSortInLL ll=new MergeSortInLL();

        ll.addFirst(10);
        ll.addFirst(7);
        ll.addFirst(23);
        ll.addFirst(3);
        

        ll.print();

        ll.head=ll.mergeSort(ll.head);
       System.out.println();
        ll.print();
    }
}
