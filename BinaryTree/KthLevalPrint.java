package BinaryTree;

public class KthLevalPrint {
    

    public static class Node{

        int data;
        Node left;
        Node right;

        public Node(int data){

            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    public static void Kthleval(Node root, int leval,int k){

        if (root==null) {
            return;
        }

        if (leval==k) {
            System.out.print( " "+root.data);
            return;
        }
      
        Kthleval(root.left, leval+1,k);  // in recursion dont use leval++ it will give wrong ans
        Kthleval(root.right,leval+1,k);
      
    }

    /*   1         1      leval is stack local variable have value differnt in evry stage..
    *     2     2     3
    *      3  4   5     6
                  3          
    */   

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

        Kthleval(root,1,1); System.out.println();
        Kthleval(root,1,2); System.out.println();
        Kthleval(root,1,3);
    }

}
