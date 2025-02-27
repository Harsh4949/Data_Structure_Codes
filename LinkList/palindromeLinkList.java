package LinkList;

public class palindromeLinkList {

    public class Node {
        
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data){

        Node newNode =new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
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


    public Node midNode(){      // this is done using slow fast method

        Node slow = head; 
        Node fast = head;      

                //Even           odd
        while (fast!=null && fast.next!=null) {
            
            slow=slow.next;
            fast=fast.next.next;        //when fast rich to end slow on middle for even and odd case
        }

        return slow;
    }

    public boolean findPalindrome(){        // it include 4 steps

            if (head==null||head.next==null) {
                return true;
            }
       
        // step 1 : find mid
          Node midNode=midNode();

        // step 2 : reverse the list from mid       draw diagram until not undersantd

         Node pre=null;
         Node cur=midNode;
         Node next;

         while (cur!=null) {

            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
            
         }

        // step 3 : Compare laft right if not Equal Retune false

         
         Node left=head;
         Node right=pre;

         while (right!=null) {
            
            if (left.data!=right.data) {
                return false;
            }

            left=left.next;
            right=right.next;
         }
         
        return true;
    }

    public static void main(String[] args) {
        
        palindromeLinkList li=new palindromeLinkList();

        li.addFirst(1);
        li.addFirst(2);
        li.addFirst(2);
        li.addFirst(1);

        li.print();

        System.out.println(li.findPalindrome());

    }
    
}
