package Stack;

import java.util.Stack;

public class PalindromeLinkList {

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

        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
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


    public static boolean isPalindrome(){

        boolean isPalin=true;

        Stack<Integer> s=new Stack<>();

        Node temp=head;

        while (temp!=null) {
            
            s.push(temp.data);           // all node are reversed in a stack 
            temp=temp.next;
        }

        // now we compare the stack peek element data and head data 

        temp=head;

        while (temp!=null) {
            
            if (s.peek()!=temp.data) {
                return false;
            }
            s.pop();
            temp=temp.next;
        }

        return isPalin;
    }

    public static void main(String[] args) {
        
        PalindromeLinkList ll =new PalindromeLinkList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(10);
        ll.addFirst(2);
        ll.addFirst(1);

        System.out.println(isPalindrome());
        ll.print();
    }
    
}
