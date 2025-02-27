package BinarySearchTree;

import BinarySearchTree.BasicBST.Node;

public class ValidateBST {   
    
    //Approch 1 take a inorder of the tree and check it sorted or not 
    //Approch 2 : use Min Max  value 
   
    public static boolean isValidBST(Node root,Node min,Node max){

        if (root==null) {
            return true;
        }

        if (min!=null && min.data>=root.data) {   // if left part data > root -- false
            return false;
        }

        if (max!=null && max.data<=root.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
      
    }

    
    public static void main(String[] args) {
        
        

        Node root=new Node(8);

        root.left=new Node(5);
        root.right=new Node(10);

        root.left.left=new Node(3);
        root.left.right=new Node(45);// false
       // root.left.right=new Node(6);// true

        root.right.right=new Node(11);


        System.out.println(isValidBST(root,null,null));

    }
}
