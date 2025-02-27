package BinaryTree;

import BinaryTree.SubtreeOfAnotherTree.Node;

public class Distancebetween2Nodes {

    // there are two approch to doing this we can use 2 stack or list to get path of two nodes 
    // and reutrn addition of size of two path-1

    //and second one is done by doing linear space

    public static Node Lca(Node root,int n1, int n2){   //lowest 1st Common ansestor

        if (root==null ||root.data==n1 || root.data==n2) {
            return root;
        }

        Node leftN=Lca(root.left, n1, n2);
        Node rightN=Lca(root.right, n1, n2);

        if (rightN==null) {
            return leftN;
        }

        if (leftN==null) {
            return rightN;
        }


        return root; // if LeftN And RigthN not null then return the node coz its ansester
         // that mens the node have resived left(n1) and right(n2) dry run the below tree for 1 

    }

    public static int distance(Node root,int n){

        if (root ==null) {
            return -1;
        }

        if (root.data==n) {
            return 0;
        }

        int lValue=distance(root.left, n);
        int rValue=distance(root.right, n);

        if (lValue==-1 && rValue==-1) { 

            return -1; // that mensa element is not presnt 

        }

        // if (lValue==-1) {
        //     return rValue+1;
        // }else
        //     return lValue+1;

        return Math.max(lValue, rValue)+1;
    }


    public static int distancebetween2Nodes(Node root,int n1,int n2) {
        
        Node lca =Lca(root, n1, n2);         //lowest 1st Common ansestor

        //System.out.println(lca.data);

        int dst1=distance(lca, n1);   // remainber we need o find the distance betwen ansestor to n1 And ansestor to n2
        int dst2=distance(lca, n2);

        return dst1+dst2;

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

        System.out.println(distancebetween2Nodes(root, 4, 6));
        System.out.println(distancebetween2Nodes(root, 1, 6));
        System.out.println(distancebetween2Nodes(root, 4, 5));
    }
}
