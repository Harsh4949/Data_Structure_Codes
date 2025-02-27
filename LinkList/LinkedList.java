package LinkList;

public class LinkedList {
    
    public class Node {                 //imagine linked list whenever do program on it draw better way
                                        // consider conditions
        int data;
        Node next;

        public Node(int data){

            this.data=data;
            this.next=null;
        }
    }

    public static Node head;    // not initailized to it null 
    public static Node tail;    // not initailized to it null 
    public static int size;


    public void addFirst(int data){     //O(1)

        Node newNode = new Node(data);
        size++;
        //check wheter it is first node
        if (head==null) {
            
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data){

        Node newNode=new Node(data);
        size++;
        //check wheter it is first node
        if (head==null) {
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

   
    public void addMiddle(int data,int idx){

        if (idx==0) {
            addFirst(data);
            return;
        }
        size++;
        int pre=0;
        Node newNode=new Node(data);
        Node temp=head;

        while (pre<idx-1) {

            temp=temp.next;
            pre++;
        }

        newNode.next=temp.next;
        temp.next=newNode;

    }

    public int removeFirst(){

        if (size==0) {
            System.out.println("LinkList is Empty...");
            return Integer.MIN_VALUE;

        }else if (size==1) {
            int val =head.data;
            head=tail=null;
            size--;
            return val;
        }

        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){

        if (size==0) {
            System.out.println("LinkList is Empty...");
            return Integer.MIN_VALUE;

        }else if (size==1) {
            int val =head.data;
            head=tail=null;
            size--;
            return val;
        }

        Node tempPrev=head;

       for(int i=0;i<size-2;i++){
            tempPrev=tempPrev.next;
       }

        tempPrev.next=null; //imp... dont forget to break linking..
        int val=tail.data; 
        tail=tempPrev;

        return val;
    }

    public int removeNthFromLast(int idx){

        //first we need to find size if in Context
        int sz=0;
        Node temp=head;
        int data=0;
        Node pre;

        while (temp!=null) {
            temp=temp.next;
            sz++;
        }

        if (idx==sz) {
            
            data=head.data;
            head=head.next;
            return data;
        }

        pre=head;
        for(int i=1;i<sz-idx;i++){         // size-idx+1 = same locatoion by reverse

            pre=pre.next;
        }

        data=pre.next.data;
        pre.next=pre.next.next;

        return data;
    }


    public int search(int key){

        Node temp=head;
        int idx=0;
        while (temp!=null) {
            
            if (temp.data==key) {
                return idx;
            }
            idx++;
            temp=temp.next;
        }
        return -1;
    }

    public int helperrecursion(int key){
          
        return recursiveSearch(head, key); 
    }

    public int recursiveSearch(Node thead,int key){ // temp head

        if (thead==null)
                return -1;
        

        if (thead.data==key) 
                 return 0;

        int idx=recursiveSearch(thead.next, key);

        if (idx==-1)   
               return -1;

        
        // idx = idx +1 wrirten directly
        return idx+1;
    }

    public void reverseList(){      //see ReverseListLogic.png image

        Node pre=null;
        Node cur=tail=head;     // we create head as a tail
        Node next;

        while (cur!=null) {
           
            next=cur.next;
            cur.next=pre;  
            pre=cur;
            cur=next;
        }
        head=pre;

        print();
    }

    public void print(){

        //Check Whether it Empty or not
        Node temp =head;

        while (temp!=null) {        //10->10->10->20->temp->>null
            
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }


    public static void main(String[] args) {
        
        LinkedList li =new LinkedList();

        li.addFirst(10); 
        li.addLast(20); 
        li.addLast(30); 
        li.addLast(40);
        
        li.addMiddle(6, 2);
    //     li.print();
    //     System.out.println("\n"+li.removeFirst()+"- removed");

    //     System.out.println(li.removeLast()+"- removed");
    //     li.print();
    //    System.out.println("\n"+size);

    //    System.out.println(li.search(30));

    //    System.out.println(li.helperrecursion( 6));
    //    li.addFirst(10); 
    //    li.print();
    //    System.out.println(li.recursiveSearch(head, 6));

    //    li.reverseList();

        li.print();
        System.out.println("\n"+li.removeNthFromLast(1)+" romoved...");

        li.print();
    }
}
