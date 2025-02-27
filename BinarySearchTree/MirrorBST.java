package BinarySearchTree;
import BinarySearchTree.BasicBST.Node;

import java.util.*;

import BinarySearchTree.BasicBST.BST;
import BinaryTree.BasicBT.BinaryTree;
public class MirrorBST {
    
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

    public static Node createMirrorBST(Node root){

        if (root==null) {
            return null;
        }

        Node left=createMirrorBST(root.left);
        Node right=createMirrorBST(root.right);

        if (root.left!=null&&root.right!=null) {   // to not check leaf node not do then also considered

            root.left=right;
            root.right=left;
        }
       return root;
    }

    public static void levalOfNodeBFS(Node root){    // BFS

            if (root==null) {
                System.out.println("Tree is empty..");
                return;
            }

            Queue<Node>queue=new LinkedList<>();

            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                
                Node curNode=queue.poll();
                
                if (curNode==null) {
                    System.out.println();

                    if (queue.isEmpty()) {  // to not go loop infinite
                        break;
                    }else  
                        queue.add(null);
                }
                else{
                    System.out.print(" "+curNode.data);

                    if (curNode.left!=null) 
                        queue.add(curNode.left);
                    
                    if (curNode.right!=null) 
                        queue.add(curNode.right);
                }                
            }
        }

    public static void main(String[] args) {
        
        int values[]={8,5,3,1,4,6,10,11,14};

        Node root=null;

        for (int i : values) {
            root=craeteBST(root, i);
        }

        levalOfNodeBFS(root);
        System.out.println();

        root=createMirrorBST(root);

        levalOfNodeBFS(root);


    }
}
