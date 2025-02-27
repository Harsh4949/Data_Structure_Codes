package BinaryTree;
import BinaryTree.BasicBT.Node;
import BinaryTree.BasicBT.BinaryTree;

public class DeleteLeafNodesValuesX {
    
    public static Node deleteLeafsOfXval(Node root ,int x){

        if (root==null ) {
            return null;
        }

        // if (root.data==x &&root.left==null &&root.right==null) {  // leaf node condotion  but it only delete the left nodes not the miidle nodes
            
        //     return null;
        // }

        root.left=deleteLeafsOfXval(root.left, x);
        root.right=deleteLeafsOfXval(root.right, x);

        if(root.data==x &&root.left==null &&root.right==null)  // now it correct now delete all nodes with
        return null;                    // delete the newly formed leaves with the target value as x. 
 
        return root;        // if not leaf node then add in tree.
    }


    public static void main(String[] args) {

        /*
         *          1                 1
         *       3     3     ->         
         *    3    3                   
         * 
         * 
         */
        

        Node root=new Node(1);

        root.left=new Node(3);
        root.right=new Node(3);

        root.left.left=new Node(3);
        root.left.right=new Node(3);
      

        new BinaryTree().levalOfNodeBFS(root); System.out.println();

        root=deleteLeafsOfXval(root, 3);

        new BinaryTree().levalOfNodeBFS(root);

    }
}
