package BinaryTree;

public class SubtreeOfAnotherTree {
    
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

    public static boolean isIdentical(Node node,Node subroot){   // node were subroot match is formrd
        
        // check the all false conditions

        if (node==null && subroot==null) {  // if left or rigth of tree and subtree have null then retun true
            return true;

        }else if ((node==null|| subroot==null) ||( node.data!=subroot.data )) {
            return false;
        }

        if (!isIdentical(node.left, subroot.left)) {  // if it gives false then retuen false
            return false;
        }

        if (!isIdentical(node.right, subroot.right)) {  // if it gives false then retuen false
            return false;
        }

        return true;
    }

    public static boolean isSubtreeOfAnotherTree(Node root,Node subroot){

        if (root==null) {
            return false;
        }

        // we need to find the subroot value is exit in root node if it is then see it identical or not

        if (root.data==subroot.data) {
            return isIdentical(root, subroot);
        }

        return isSubtreeOfAnotherTree(root.left, subroot) ||isSubtreeOfAnotherTree(root.right, subroot);

        //id left part or right part have return true mens subtree is part of tree. 
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


        /*              
        *          2     
        *        4   5             
        */  

        Node subtrr=new Node(2);
        subtrr.left=new Node(4);
        subtrr.right=new Node(5);

        System.out.println(isSubtreeOfAnotherTree(root, subtrr));
    }
}
