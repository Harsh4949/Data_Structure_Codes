package BinaryTree;

import Array_quetions.Array2D.diagonalSum;

public class minDepthOfTree {
    
    static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){

            this.data=data;
        }
    }


    static class BinaryTree{

        static int idx=-1;


        public static Node bulidBT(int[]nodes){

            idx++;

            if (nodes[idx]==-1) {
                return null;
            }

            Node newnNode=new Node(nodes[idx]);
            newnNode.left=bulidBT(nodes);
            newnNode.right=bulidBT(nodes);

            return newnNode;
        }

        public static int mindepth(Node root){

            if (root==null) {
                return 0;
            }

            int leftmin=mindepth(root.left);
            int rightmin=mindepth(root.right);

            if (root.left==null || root.right==null) {   // to handle the condition of right side if 3 have only right child
                                                         // then Math.min(0,5) gives 0 thats worng coz right have furthr tree
                return Math.max(leftmin, rightmin)+1;
            }

            return Math.min(leftmin, rightmin)+1;
        }
    }

    public static void main(String[] args) {

        
        /*            1  
        *          2     3
        *        4   5     6
                         7   
                       8   
        */             
        
        int node2[] ={1,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,8,-1,-1}; 



        BinaryTree tree=new BinaryTree();

         Node root= tree.bulidBT(node2);

         System.out.println(tree.mindepth(root));


    }
}
