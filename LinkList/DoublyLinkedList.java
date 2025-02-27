package LinkList;

public class DoublyLinkedList {         // *** drawing diagram for evry Function is imporant ***
    
    public class Node{
        
        Object data;
        Node next;
        Node prev;

        public Node(Object data){

            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size=0;

    public void addFirst(Object data){

        Node newNode= new Node(data);

        if (head==null) {
            
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    public void addLast(Object data){

        Node newNode= new Node(data);

        if (head==null) {
            
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }


    public Object removeFirst(){

        if (head==null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        Object data;

        if (head.next==null) { // if only one 
            
            data=head.data;
            head=tail=null;
            return data;
        }

       data=head.data;

       head=head.next;
       head.prev=null;

        return data;
    }

    
    public Object removeLast(){

        if (head==null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        Object data;

        if (head.next==null) { // if only one 
            
            data=head.data;
            head=tail=null;
            return data;
        }

       data=tail.data;

       tail=tail.prev;
       tail.next=null;

        return data;
    }


    public void print(){

        if (head==null) {
            System.out.println("list is Empty");
            return;
        }

        Node temp=head;

        while (temp!=null) {
            
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }

        System.out.println("null");
    }

    public void printfromLast(){

        if (head==null) {
            System.out.println("list is Empty");
            return;
        }

        Node temp=tail;

        while (temp!=null) {
            
            System.out.print(temp.data+"<->");
            temp=temp.prev;
        }

        System.out.println("null");
    }

    public void reverseDLL(){

        Node pre=null;
        Node cur=head;
        Node next;

        while (cur!=null) {
            
            next=cur.next;

            cur.next=pre;
            cur.prev=next;

            pre=cur;
            cur=next;
        }
        head=pre;
    }


    public static void main(String[] args) {
        
        DoublyLinkedList DLL=new DoublyLinkedList();

        DLL.addFirst("40har");
        DLL.addFirst(30);
        DLL.addFirst('M');
        DLL.addFirst(true);
        DLL.addFirst(5);

        DLL.addLast(50);
        
        // DLL.print();
        // System.out.println(DLL.removeFirst());
        // System.out.println(DLL.removeFirst());
        // System.out.println(DLL.removeLast());
        // System.out.println(DLL.removeLast());

        //DLL.reverseDLL();

        DLL.print();
        DLL.printfromLast();
    }
}
