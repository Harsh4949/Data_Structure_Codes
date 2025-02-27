package BinaryTree;

import BinaryTree.BasicBT.Node;

public class CheckBTIsUnivalued {


    public static boolean IsUnivalued(Node root){

        if (root==null ) {
            return true;
        }

        // int left=root.left==null?root.data:root.left.data;   its corect but we dont need to campare last leval of leaf node
        // int right=root.right==null?root.data:root.right.data;

        if (root.right!=null && root.data!=root.right.data)  return false;  // here we campare root with left and right 
                                                                            // and compare stop before one leval of leaf node
        if (root.left!=null && root.data!=root.left.data)  return false;     

        return IsUnivalued(root.left)&&IsUnivalued(root.right);

    }


    public static void main(String[] args) {

        /*
                        2                           2            2        // two camparison take place
                    2       2                     2    2      5    2
                 5     2   
         * 
         */
        
        Node root=new Node(2);

        root.left=new Node(2);
        root.right=new Node(2);

        root.left.left=new Node(5);
        root.left.right=new Node(2);

        if(IsUnivalued(root))
                System.out.println("Yes");
        else
             System.out.println("No");

    }
    
}
