package BinaryTree;
import java.util.*;

public class BasicBT {
   
    public static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){

            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static class BinaryTree{

        static int idx=-1;

        public static Node bulidTree(int [] nodes){   // don,t take node if you waana built tree form 0;

            idx++;

            //base case

            if (nodes[idx]==-1) {
                return null;
            }

            //recursion

            Node root= new Node(nodes[idx]);  // root node , to add a Node 

            root.left=bulidTree(nodes);      // add node to the left side until found -1 null   
            root.right=bulidTree(nodes);  // add node to the right side until found -1 null  

            return root;
        }

            
        public static void preorder(Node root){  //NLR

            if (root==null) {
                //System.out.println();
                return;
            }

            System.out.print(" "+root.data);
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){   //LNR

            if (root==null) {
                return;
            }


            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);

        }

        public static void postOrder(Node root){  //LRN

            if (root==null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" "+root.data);
        }

        public static void levalOfNodeBFS(Node root){    // BFS

            if (root==null) {
                System.out.println("Tree is empty..");
                return;
            }

            Queue<Node>queue=new LinkedList<>();

            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                
                Node curNode=queue.poll();
                
                if (curNode==null) {
                    System.out.println();

                    if (queue.isEmpty()) {  // to not go loop infinite
                        break;
                    }else  
                        queue.add(null);
                }
                else{
                    System.out.print(" "+curNode.data);

                    if (curNode.left!=null) 
                        queue.add(curNode.left);
                    
                    if (curNode.right!=null) 
                        queue.add(curNode.right);
                }                
            }

            /*
            *
            * Leval Of Node Print Logic: 
                                *            1  
                                *         2     3
                                *       4    5    6
            *
            *  queue :-  1 N 2 3 N 4 5 6 N
            *              |---------> 
            * 
            *  - here we itrate queue 1 by one 
            *  - if node encounter then print and add thier left and right if not null 
            *  - if null occur then print new line and add this null to end of queue for next time print new line to new leval
            * 
            */
        }

        
        public static int depthOfTree(Node root){  // see logic in 

            //exit 
            if (root==null) {           //were we each node and thier left and right node count 
                return 0;               // at last node it return 0 for left and rigth 
            }

            //recursion
            int hl=depthOfTree(root.left);
            int hr=depthOfTree(root.right);

            return Math.max(hl, hr)+1;    //at last leaf node 0+0= 1 now it increse as tree go above form leaf
        }

        /*            1  
        *          2     3
        *        4    5    6
                         7   
                       8   
                        height =5
        */              

        public static int countNodes(Node root){

            if (root==null) {
                return 0;
            }
            // here we go till leaf node and then see left right and add one do dry run to understand
            return countNodes(root.left)+countNodes(root.right)+1;
        }


        /*                       1          (3+2)+1=6

        *   3=(1+1)+1         2     3       (0+1)+1=2

        *  (0+0)+1=1        4    5    6    (0+0)+1=1
                           (0+0)+1=1                  
        */           


        public static int sumOfNode(Node root){

            if (root==null) {
                return 0;
            }
           // same logic as count nodes there we add 1 and here we add data of current node.
            return sumOfNode(root.left)+sumOfNode(root.right)+root.data;
        }


        /*                       1          (11+9)+1= 21

        *  11=(4+5)+ 2        2       3       (0+6)+3=9

        *  (0+0)+4=4        4    5       6    (0+0)+6=6
                           (0+0)+5=5                  
        */      
    }



    public static void main(String[] args) {
        

        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int node2[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,8,-1,-1};  // ex. for calculate depth of tree

        BinaryTree tree=new BinaryTree();
        BinaryTree tree2=new BinaryTree();

        Node root=tree.bulidTree(nodes);

      //  Node root2=tree2.bulidTree(node2);   // ex. for calculate depth of tree

        //System.out.println(root.data);


        // tree.preorder(root); System.out.println();
        // tree. inorder(root); System.out.println();
        // tree.postOrder(root); System.out.println();


        // tree.levalOfNode(root);
        // tree.levalOfNode(root2); 
        // System.out.println(tree.depthOfTree(root2));

        System.out.println(tree.countNodes(root));
      ///  System.out.println(tree.countNodes(root2));

      //System.out.println(tree.sumOfNode(root));

    }
}

/*
 *
 * Leval Of Node Print Logic: 
                    *            1  
                    *         2     3
                    *       4    5    6
 *
 *  queue :-  1 N 2 3 N 4 5 6 N
 *              |---------> 
 * 
 *  - here we itrate queue 1 by one 
 *  - if node encounter add thier left and right if not null
 *  - if null occur then print new line and add this null to end of queue for next time print new line to new leval
 * 
 */

