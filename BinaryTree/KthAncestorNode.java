package BinaryTree;

import BinaryTree.SubtreeOfAnotherTree.Node;

public class KthAncestorNode {


        public static int kthAncestorNode(Node root, int n, int k){

            if (root==null) {
                return -1;
            }

            if (root.data==n) {
                return 0;
            }

            int ld=kthAncestorNode(root.left, n, k);
            int rd=kthAncestorNode(root.right, n, k);

            if (ld==-1 && rd==-1) {  // neccessory if you retun -1 coz it calculate left and rigt even elemt is not found
                return -1;
            }

            int max=Math.max(ld, rd)+1;

            if (max==k) {
                System.out.println(root.data);
            }

            return max;
            
        }
    

    public static void main(String[] args) {
        /*            1  
        *          2     3
        *        4   5     6
                             
        */    

        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);

         kthAncestorNode(root, 5, 1);
        kthAncestorNode(root, 5, 2);
        kthAncestorNode(root, 4, 1);
    }
}
