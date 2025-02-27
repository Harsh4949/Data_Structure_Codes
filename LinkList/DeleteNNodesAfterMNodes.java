package LinkList;

public class DeleteNNodesAfterMNodes {
    
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

    public void deleteNnodeAfterMNode(int m,int n){         //where mn must be within the size

        if (m<0) m=1;

        Node curM=head;
        Node lastN;

        for(int i=1;i<m;i++){
            curM=curM.next;
        }

        lastN=curM;
        for(int i=m;i<n;i++){

            if (lastN.next==null) {
                break;
            }

            lastN=lastN.next;
        }

    
        curM.next=lastN.next;

        print();
    
        
    }

    public static void main(String[] args) {
        
        DeleteNNodesAfterMNodes ll= new DeleteNNodesAfterMNodes();

        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();

        ll.deleteNnodeAfterMNode(2,4);
    }
}
