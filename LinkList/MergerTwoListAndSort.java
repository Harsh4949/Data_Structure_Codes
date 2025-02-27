package LinkList;

class Node{
     
    int data;
    Node next;

    public Node(int data){

        this.data=data;
        this.next=null;
    }
}

public class MergerTwoListAndSort {
    
    public static Node head;

    public static Node sorteList(Node a,Node b){

        Node result;
       
        if (a==null) 
            return b;

        if (b==null) 
            return a;

        if (a.data <= b.data) {
            
            result=a;
           result.next= sorteList(a.next, b);
           
        }else{
            result=b;
            result.next = sorteList(a, b.next);
        }
        
        return result;
    }

    public static Node mergeLlits(Node []lists,int lastLL){

        while(lastLL!=0){

            int i = 0, j = lastLL;

            // Use two-pointer approach to merge lists
            while (i < j) {
                lists[i] = sorteList(lists[i], lists[j]); // Merge two lists
                i++;
                j--;
            }

            lastLL=j;  // when remaining one node.. 012 , for 0 and 1
        }

        return lists[0];
    }

    public static void printList(Node node){ 
       
        while (node != null) { 
            System.out.print(node.data + " "); 
            node  = node.next; 
        } 
    } 

    public static void main(String[] args) {
        
        int k = 3; 
        int n = 4; 
        Node arr[] = new Node[k]; 
        
        arr[0] = new Node(1); arr[0].next 
        = new Node(3); arr[0].next.next = 
        new Node(5); 
        arr[0].next.next.next = new Node(7); 
        
        arr[1] = new Node(2); arr[1].next 
        = new Node(4); arr[1].next.next = 
        new Node(6); 
        arr[1].next.next.next = new Node(8); 
        
        arr[2] = new Node(0); 
        arr[2].next = new Node(9); 
        arr[2].next.next = new Node(10); 
        arr[2].next.next.next = new Node(11);

        Node head = mergeLlits(arr, k - 1); 
        printList(head);

    }
}

/*
 * Time Complexity : o(n*logk) 
    Space Complexity: o(n) 
 * Dry Run:
    Initial State:
        arr = [List1, List2, List3, List4]
  
        List1: 1 -> 4 -> 7
        List2: 2 -> 5 -> 8
        List3: 3 -> 6
        List4: 0 -> 9
        last = 3 i.e arr.length-1;

    Outer Loop (Iteration 1):

                i = 0, j = 3

        Inner Loop:

            Merge arr[0] and arr[3]:

            arr[0] = SortedMerge(List1, List4)
            Result: 0 -> 1 -> 4 -> 7 -> 9
            Updated arr = [List0, List2, List3, null]
            Increment i = 1, Decrement j = 2.
            Merge arr[1] and arr[2]:

            arr[1] = SortedMerge(List2, List3)
            Result: 2 -> 3 -> 5 -> 6 -> 8
            Updated arr = [List0, List1, null, null]
            Increment i = 2, Decrement j = 1.
            Break Condition: i >= j, set last = 1.

    Outer Loop (Iteration 2):
            i = 0, j = 1

        Inner Loop:

            Merge arr[0] and arr[1]:
            arr[0] = SortedMerge(List0, List1)
            Result: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
            Updated arr = [List0, null, null, null]

        Increment i = 1, Decrement j = 0.

    Break Condition: i >= j, set last = 0.

        Final State:
        arr[0]: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        last = 0

    Outer loop terminates.

 */