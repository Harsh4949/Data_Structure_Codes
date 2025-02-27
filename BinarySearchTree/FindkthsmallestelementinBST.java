package BinarySearchTree;

import java.util.ArrayList;

import BinarySearchTree.BasicBST.Node;

public class FindkthsmallestelementinBST {
    
    public static void inorderSeq(Node root,ArrayList<Integer> arr){

        if (root==null) {
           return ;
        }

        inorderSeq(root.left,arr);
        arr.add(root.data);
        inorderSeq(root.right,arr);

    }

    public static int kthSmallestElemtBST(Node root,int k){

        ArrayList<Integer> arr=new ArrayList<>();

        inorderSeq(root, arr);

        return arr.get(k-1); // inorder gives the asending order list

    }
    public static void main(String[] args) {
        
    }
}
