package LinkList;

public class IntersectingOfNodes {
    
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

    public Node getIntersectionNode(Node headA, Node headB) {

        //find length of two list

        Node temp=headA;
        int len1=0;
        int len2=0;

        while(temp!=null){
            len1++;
            temp=temp.next;
        }

        temp=headB;

        while(temp!=null){
            len2++;
            temp=temp.next;
        }
        
        Node cur1=headA;
        Node cur2=headB;
        int diff;

        // increse to make equl
        if(len1>=len2){
            diff=len1-len2;

            for(int i=0;i<diff;i++){
                cur1=cur1.next;
            }
        }

         if(len1<=len2){
            diff=len2-len1;

            for(int i=0;i<diff;i++){
                cur2=cur2.next;
            }
        }
 // increse both simultenusly
        while(cur1!=null && cur2!=null){

            if(cur1==cur2){
                return cur1;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        // do linklist that intersect
    }
}
