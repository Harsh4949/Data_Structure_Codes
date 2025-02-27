package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsortedLL {

    static class Node {
    
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
        }
    }

    static class NodeComparator implements Comparator<Node> {  // for leateCode Another way to sort Object

        @Override
        public int compare(Node o1, Node o2) {
           
            return o1.data-o2.data;
        }
    
    }

    public static Node mergeKLists(Node []rootNs,int K){  //K No. if Lists  if use for loop then take otherisw not take
        
        PriorityQueue<Node> pq =new PriorityQueue<>(new NodeComparator());
        Node head=new Node(0);       // creating a Dummy head Node to append Nodes

        Node last=head; // act as Tail where we append samll nodes to large

        // 1> add all the root Nodes in pq

        for (Node root : rootNs) {
            
            if (root!=null) {    // check not any root node are null
                pq.add(root);
            }
        }

        // check after loading all roots in pq, size of pq is Not a Empty , ie. in case all roots are null given then

        if(pq.isEmpty()) return null;

        // do the below process ut il pq not get empty
        /*
         * 1> remove the elemt 
         *  2> append to tail
         *  3> add the next of removed elemt it not null
         */

        while (!pq.isEmpty()) {
            
            Node cur= pq.remove();

            last.next=cur;  // append last
            last=last.next;  // incremet last

            if (cur.next!=null) {
                pq.add(cur.next);
            }

            for (Node node : pq) {                // to understanding...
                System.out.print(" "+node.data);
            }
            System.out.println();
        }


        return head.next; // to remove Dummy 0
    }

    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        
        /*
         *  K=3, M=3
         * 
         * list1 : 1->3->7->NuLL
         * list2 : 2->4->8->NuLL
         * list3 : 9->10->11->NuLL
         * 
         */

         int K=3;
         int M=3;
         // Creating list1: 1 -> 3 -> 7 -> NULL
        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(7);

        // Creating list2: 2 -> 4 -> 8 -> NULL
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(8);

        // Creating list3: 9 -> 10 -> 11 -> NULL
        Node list3 = new Node(9);
        list3.next = new Node(10);
        list3.next.next = new Node(11);

        // Storing root nodes in an array
        Node[] nodeArray = {list1, list2, list3};

        Node root= mergeKLists(nodeArray, K);

       
        printList(root);
        
    }
}