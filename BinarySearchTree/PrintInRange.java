package BinarySearchTree;

import BinarySearchTree.BasicBST.Node;

public class PrintInRange {
    
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

    public static void printInRange(Node root,int k1,int k2){

        if (root==null) {
            return;
        }

        if (k1>root.data ) {     // if k1 and k2 present in right subtree
           
            printInRange(root.right, k1, k2);
        }
    
        else if (root.data>=k1 && root.data<=k2) {     // print data betn k1 and k2
            
            System.out.println(""+root.data);
            printInRange(root.left, k1, k2);
            printInRange(root.right, k1, k2);

        }else{
            printInRange(root.left, k1, k2);  // if k1 and k2 present in left subtree
        }
        
    }

    public static void main(String[] args) {
        
        int values[]={8,5,3,1,4,6,10,11,14};    // refer tree DeleteNodeInBT.png

        Node root=null;

        for (int i : values) {
            root=craeteBST(root, i);
        }

        printInRange(root, 1, 4);

    }
}
