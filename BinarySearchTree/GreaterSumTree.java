package BinarySearchTree;

import javax.swing.tree.TreeNode;

import BinarySearchTree.AVLTree.Node;

public class GreaterSumTree {

     int sum;

    public void helper(Node root) {

        if(root != null) {
            helper(root.right);
            sum = sum + root.data;
            root.data = sum;
            helper(root.left);
        }

    }

    public Node bstToGst(Node root) {
        sum = 0;

        helper(root);
        return root;
    }
    
    public static void main(String[] args) {
        
    }
}