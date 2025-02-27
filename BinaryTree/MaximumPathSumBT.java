package BinaryTree;

import BinaryTree.BasicBT.Node;
import Stringque.replaceWithString;

public class MaximumPathSumBT {

   static int maxsum=Integer.MIN_VALUE;

    public static int maximumPathSumBT(Node root){

        if (root==null)    return 0;
            
        int lh=maximumPathSumBT(root.left);  // left diameter 
        int rh=maximumPathSumBT(root.right);

        //where the diametr is total no. of nodes in left and right slide 

        if (lh<0) return lh=0; 
        if (rh<0) return rh=0; 

        maxsum=Math.max(lh+rh+root.data,maxsum);

        return Math.max(lh,rh)+root.data; // which node have maximum diameter here we waana display
    }

    public static void main(String[] args) {

        /*
         *         -10
         *       9      20
         *           15    7
         * 
         * 
         */
        
        
        Node root=new Node(-10);

        root.left=new Node(9);
        root.right=new Node(20);

        root.right.left=new Node(15);
        root.right.right=new Node(7);

        maximumPathSumBT(root);
        System.out.println(maxsum);
    }
}