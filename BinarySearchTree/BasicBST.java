package BinarySearchTree;


import java.util.Queue;

import java.util.*;

public class BasicBST {
    
    static class Node {
    
        int data;
        Node left;
        Node right;

        public Node(int data){

            this.data=data;
            this.left=this.right=null;
        }
    }

    static class BST {

        public Node insert(Node root,int val){  //  5,1,3,4,2,7

            if (root==null) {        // root always null if it first time insert or new data insert conz it goes to depth
                root= new Node(val);
                return root;
            }

            if (val<root.data) {                     //   if value if less than root then add left
                root.left =insert(root.left, val); 

            }else                                       //right
                root.right= insert(root.right,val ); 
            
            return root;

        }

         /*
         *          5
         *       1     7
         *     2   3
         *          4
         * 
         */

        public static boolean searchTree(Node root,int val){  // 3

            if (root==null) {
                return false;
            }

            if (root.data==val) {
                return true;
            }

            if (val<root.data) { // val less than root
                return searchTree(root.left, val);
            }else
                 return searchTree(root.right, val);

           // return (val<root.data)? searchTree(root.left, val): searchTree(root.right, val);  it is also correct
            
        }

        public static Node inorderSuccesor(Node root){  // SI is always present in left Bottom In Right part

            while (root.left!=null) {                // not need to check the root null condition coz
                                                    // we checked in below fuction
                root=root.left;
            }

            return root;
        }

        public static Node deleteNodeBT(Node root,int val){  //O(h) height of the tree

            if (root==null) return null;
                
            // first serch the element

            if (val<root.data) {                          // val presnt in left part of tree
            root.left=deleteNodeBT(root.left, val);

            }else if (val>root.data) {                          // val presnt in right part of tree
                root.right=deleteNodeBT(root.right, val);

            }else{                                             // *val is Found* But 3 Cases for Delete

                //Case 1: if It is left Node
                if (root.left==null && root.right==null) {
                    return null;                             // if 2 and 3 then 3 node pass null that mens 2->r =null
                }

                //Case 1: if Node have single child  

                if (root.left==null) {                //Node have right node
                    return root.right;                // if 1 2 3 And we wanna delete 2 then 2 return 3 ---> 1 3

                }else if (root.left==null) { 
                                                    //Node have left node
                    return root.left;
                }

                 //Case 3: if Node have Both Node left and right

                 Node IS=inorderSuccesor(root.right);
                 root.data=IS.data;             //exachage the values
                 root.right=deleteNodeBT(root.right, IS.data);  // then delete that node Where Is Deggre =0,1; that can we handel in above 
                 
                
                
                //Logic :
                // It it is then we get the immidiate succesor of that node
                //Ex : 8,5,3,1,4,6,10,11,14   if we waana delete 5 then then we take IS= 6
                // to getting this it always presnt in Right part (Least Left Node)  consider example and dry run
                // see img : " D:\Programming\vscodeProgram\BinarySearchTree\DeleteNodeInBT.png "

            }

            return root;

        }


        public static void inorder(Node root){

            if (root==null) {
                return;
            }

            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);
         }
    }

    public static void main(String[] args) {

       
        
        int values[]={8,5,3,1,4,6,10,11,14};

        BST bst =new BST();

        Node root=null;

        for (int i : values) {
            root=bst.insert(root, i);
        }
        

        bst.inorder(root);
        System.out.println();

        System.out.println(bst.searchTree(root, 3));

        root=bst.deleteNodeBT(root, 8);
        // root=bst.deleteNodeBT(root, 6);
        // root=bst.deleteNodeBT(root, 14);
        // root=bst.deleteNodeBT(root, 3);

        bst.inorder(root);
        System.out.println();

    }
}
