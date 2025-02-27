package Stack;

public class StackLinkList {
    
    public class Node {
        
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }  
    } 

    public static Node head;
    public static int peek=0;

    public boolean isEmpty(){

        return head==null;
    }

    public void push(int data){

        Node newnNode=new Node(data);

        if (head==null) {
            head=newnNode;
            peek++;
            return;
        }

        newnNode.next=head;
        head=newnNode;
        peek++;
    }

    public int pop(){

        if (isEmpty()) {
            System.out.println("Stack is Empty.!!");
            return -1;
        }

        int data=head.data;
        head=head.next;
        peek--;
        return data;
    }
        
    public void print(){

        //Check Whether it Empty or not
        Node temp =head;

        while (temp!=null) {        //10->10->10->20->temp->>null
            
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null"+"\n");
    }

    public static void main(String[] args) {
        
        StackLinkList ll=new StackLinkList();

        ll.push(10);
        ll.push(20);
        ll.push(30);
        ll.push(40);

        ll.print();

        System.out.println(ll.pop());
        System.out.println(ll.pop());


        ll.print();

        System.out.println(ll.peek);
    }
}
