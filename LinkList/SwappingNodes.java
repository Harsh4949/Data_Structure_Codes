package LinkList;

public class SwappingNodes {
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

    public void swapNodes(int x ,int y){

        if(x == y) 
            return; 
        
        Node curxNode=head;
        Node curyNode=head;
        Node prXNode=null;
        Node prYNode=null;

        while (curxNode!=null && curxNode.data!=x) {
            
            prXNode=curxNode;
            curxNode=curxNode.next;
            
        }

        while (curyNode!=null && curyNode.data!=y) {
            
            prYNode=curyNode;
            curyNode=curyNode.next;
            
        }

        if (curxNode == null || curyNode == null) 
                        return; 

        if (prXNode != null) {
            prXNode.next = curyNode;
        } 
        else {
            head = curyNode;
        }
        
        if (prYNode != null) {
            prYNode.next = curxNode;

        } else {
            head = curxNode;
        }
                        
      
        Node temp=curxNode.next;
        curxNode.next=curyNode.next;
        curyNode.next=temp;

    }
        

    public static void main(String[] args) {
        
        SwappingNodes ll= new SwappingNodes();

        ll.addFirst(40);
        ll.addFirst(30);
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addFirst(5);
        ll.addFirst(2);

        ll.print();

        ll.swapNodes(5, 30);

        ll.print();
    }
}
