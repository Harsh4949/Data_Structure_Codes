package LinkList;

public class EvenOddLinkList {

    Node head;

    class Node{ 

        int data; 
        Node next; 

        Node(int d){ 
            data = d; 
            next = null; 
        } 
    } 

    void segregateEvenOdd(){ 

        Node end = head; 
        Node prev = null; 
        Node curr = head; 

        while (end.next != null) 
            end = end.next; 

        Node new_end = end; 

        while (curr.data %2 !=0 && curr != end){ //imp
            new_end.next = curr; 
            curr = curr.next; 
            new_end.next.next = null;  //** */
            new_end = new_end.next;   
        } 

        if (curr.data %2 ==0){ 
             head = curr; 

            while (curr != end){ 

                if (curr.data % 2 == 0){ 
                    prev = curr; 
                    curr = curr.next; 
                } 
                else{  
                    prev.next = curr.next; 
                    curr.next = null; 
                    new_end.next = curr; 
                    new_end = curr; 
                    curr = prev.next; 
                 } 
            } 
        } 
        else 
            prev = curr;

        if (new_end != end && end.data %2 != 0){ 

            prev.next = end.next; 
            end.next = null; 
            new_end.next = end; 
        } 
    }
        

    void push(int new_data){ 

        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 

    } 

    void printList(){ 
        Node temp = head;

        while(temp != null){ 
            System.out.print(temp.data+" "); 
            temp = temp.next; 
        } 

        System.out.println(); 
    } 


    public static void main(String args[]){ 

        EvenOddLinkList llist = new EvenOddLinkList(); 

        llist.push(11); 
        llist.push(10); 
        llist.push(3); 
        llist.push(6);
        llist.push(4); 
        llist.push(2); 
        llist.push(7); 

        System.out.println("Linked List"); 
        llist.printList(); 

        llist.segregateEvenOdd(); 
        System.out.println("updated Linked List"); 

        llist.printList(); 

    } 
} 



/*
 * 
 * Dry Run Input: https://chatgpt.com/share/6790f3f3-04fc-8008-9897-35cc21475993

        Time Complexity : o(n) Space 
        Complexity: o(1)
 */