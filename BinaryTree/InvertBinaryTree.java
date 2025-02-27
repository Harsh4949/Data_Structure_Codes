package BinaryTree;

import BinaryTree.BasicBT.Node;
import BinaryTree.BasicBT.BinaryTree;

public class InvertBinaryTree {
    
    public static void invertBT(Node root){

        if (root==null) {
            return;
        }

        if (root.left!=null&&root.right!=null) {

            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }

        invertBT(root.left);
        invertBT(root.right);

    }

    public static void main(String[] args) {


           /*         1                  1                 1
                    /   \              /   \             /   \
        *          2     3      ->    3     2     ->    3     2
                  / \   / \          / \   / \         / \   / \
        *        4   5 6   7        6   7 4   5       7   6  5  4

        */
        

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        new BinaryTree().levalOfNodeBFS(root);

        invertBT(root);

        new BinaryTree().levalOfNodeBFS(root);
        
    }
}
