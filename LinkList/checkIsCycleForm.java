package LinkList;

public class checkIsCycleForm {

    public class Node {
        
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;

    public static boolean isCycleForm(){    // here we use slow fast pointer

        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null) {     //**imp for even-odd size of LL condition
            
            slow=slow.next;         //+1
            fast=fast.next.next;    //+2

            if (slow==fast) {
                return true;    //mathemathically they meet one if cycle is formed
            }
        }
        
        return false;
    }

    public static void removeCycle(){

        //find the meeting point of slow and fast i.e detect cycle

        Node slow =head;
        Node fast= head;
        boolean isCycleForm=false;

        while (fast!=null && fast.next !=null) {
            
            slow=slow.next;       //+1
            fast=fast.next.next;  //+2

            if (slow==fast) {
                isCycleForm=true;
                break;              //must to stop
            }
        }


        if (isCycleForm==false) {      
            return;
        }  
            
             slow=head;              // if cycle detect Initialize slow to head
            Node pre =null;

            while (slow!=fast) {              // find the meeting point agin by mov fast By one 

                slow=slow.next;
                pre=fast;
                fast=fast.next;
            }
          
            pre.next=null;              //inialize last node to one

            System.out.println("Cycle is removed...\n");
       
    }

    public void print(){

        Node temp=head;

        if (temp==null) {
            System.out.println("List is empty...");

        }
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        checkIsCycleForm li= new checkIsCycleForm();
        
        head=li.new Node(10);
        head.next=li.new Node(20);
        head.next.next=new checkIsCycleForm().new Node(30);

        head.next.next.next=head.next; // now cycle is formed

        System.out.println(isCycleForm());
        
        removeCycle();
        
        System.out.println(isCycleForm());
        li.print();
    }
}