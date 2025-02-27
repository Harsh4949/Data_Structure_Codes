package BinarySearchTree;

import java.util.ArrayList;

import BinarySearchTree.BasicBST.Node;

public class RootToLeafPath {
    
    public static Node craeteBST(Node root,int val){

        if (root==null) {  
            root=new Node(val);
            return root;
        }

        if (val<root.data) {
            root.left=craeteBST(root.left, val);
        }else
            root.right=craeteBST(root.right, val);

        return root;

    }

    public static void rootToLeafPaths(Node root,ArrayList<Integer> path){

        if (root==null) {
            return;
        }

       
        path.add(root.data);
        rootToLeafPaths(root.left, path);
        rootToLeafPaths(root.right, path);
        
        if (root.left==null && root.right==null) {
            System.out.println(path);
        }

        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        
        int values[]={8,5,3,1,4,6,10,11,14};    // refer tree DeleteNodeInBT.png

        Node root=null;

        for (int i : values) {
            root=craeteBST(root, i);
        }


        rootToLeafPaths(root, new ArrayList<Integer>());
        

    }
}
