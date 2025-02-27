package BinarySearchTree;

import BinarySearchTree.BasicBST.Node;

public class SortedArrayBalancedBST {  

        /*      EX :-unbalenced                               Balenceed

         *               1                                      1
         *            8     10                              5      11  
         *         5           11               ->       3    8   10   12 
         *       3                12
         * 
         *  
         * 
         */

    
    public static Node sortedArrayBalancedBST( int arry[],int si ,int ei){          // ** dont Root as argument if you build tree Form 0;

        if (si>ei) {           //    0 > -1  false
            return null;
        }

        int mid=(ei+si)/2;

        Node root=new Node(arry[mid]);
        
        root.left=sortedArrayBalancedBST(arry,si,mid-1); // eleminate mid coz it inserted..
        root.right=sortedArrayBalancedBST( arry,mid+1,ei);

        return root;
    }

    public static void inorder(Node root){

        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);

    }

    public static void main(String[] args) {
        
        int arry[]={3,5,6,8,10,11,12};

        Node root=null;
        root=sortedArrayBalancedBST(arry,0,arry.length-1);

        inorder(root);



    }
}
