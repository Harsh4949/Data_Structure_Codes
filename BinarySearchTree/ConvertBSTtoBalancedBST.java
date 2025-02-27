package BinarySearchTree;

import java.util.ArrayList;
import BinarySearchTree.BasicBST.Node;

public class ConvertBSTtoBalancedBST{

    public static void inorder(Node root,ArrayList<Integer> inorder){

        if(root==null) return;

        inorder(root.left, inorder);
        inorder.add(root.data);         // 3 5 8 1 10 11 12
        //System.out.print(" "+root.data);           
        inorder(root.right, inorder);
    }

    public static Node balenceBST(ArrayList<Integer> inorder,int si,int ei){

        if(si>ei)  return null;

        int mid=(ei+si)/2;

        Node root=new Node(inorder.get(mid));

        root.left=balenceBST(inorder, si,mid-1);
        root.right=balenceBST(inorder,mid+1,ei);
        
        return root;
    }

    public static Node convertBSTtoBalancedBST(Node root){

        //1> get inorder
        ArrayList inorder =new ArrayList<>();
        inorder(root, inorder);

        //1>use inorder to create Balenced BST

        root=balenceBST(inorder,0,inorder.size()-1);

        return root;

    }
    
    public static void inorder(Node root){

        if(root==null) return;

        inorder(root.left);
        System.out.print(" "+root.data);    
        inorder(root.right);
    }


    public static void main(String[] args) {

     
        /*         unbalenced                               Balenceed
         *               1                                      1
         *            8     10                              5      11  
         *         5           11               ->       3    8  10   12 
         *       3                12
         * 
         *  1> take inorder         2.> do balenced Tree
         * 
         */


         Node root= new Node(1);

         root.left= new Node(8);
         root.left.left= new Node(5);
         root.left.left.left= new Node(3);

         root.right= new Node(10);
         root.right.right= new Node(11);
         root.right.right.right= new Node(12);

       

        inorder(root);
    }
}