package BinaryTree;

import BinaryTree.BasicBT.Node;
import BinaryTree.BasicBT.BinaryTree;;

public class TransformSumTree {


    public static int transformSumTree(Node root){

        if (root==null) {
            return 0;
        }

        int leftchild=transformSumTree(root.left);
       
        int rightchild=transformSumTree(root.right);

        int nodedataadd =root.data;

        int newLeft =  root.left==null  ? 0 : root.left.data;   // importtant to handle condition at leaf node 
        int newright = root.right==null ? 0 : root.right.data;

        root.data=(leftchild+newLeft)+(rightchild+newright);

        return nodedataadd;
    }

    
    public static void main(String[] args) {
        
                
         /*           1
                    /   \
        *          2     3     
                  / \   / \
        *        4   5 6   7    

                      1     (9+2+3+13)  27
                    /   \
        *      9   2     3    (0+6+0+7)  13
                  / \   / \
        *        4   5 6   7       
                0    0 0    0
                             
        */    

       
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        
        new BinaryTree().levalOfNodeBFS(root);

        transformSumTree(root);
      

        new BinaryTree().levalOfNodeBFS(root);
    }
}
