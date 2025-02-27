package BinaryTree;
import java.util.ArrayList;

import  BinaryTree.SubtreeOfAnotherTree.Node;
import Stringque.replaceWithString;

public class LowestCommonAncestor {


    public static boolean getPath(Node root,ArrayList<Node>path ,int n){

        if (root==null) {
            return false;
        }

        path.add(root);  // root data added

        if (root.data==n) {  // if data found then add and return true
            return true;
        }

        boolean lp=getPath(root.left, path, n);  // 1 2 3  go depth till get false
        boolean rp= getPath(root.right, path, n);

        if (lp || rp) {   // when rech left or rigt part and found elemtn then retun back true and go back
            return true;
        }

        /*
         * if (!(lp || rp))  path.remove(path.size()-1); 
         * coz we handle ture conditon we dont need to write false condition
         * 
         */

        path.remove(path.size()-1); // 1 2 3(removed if it not n) // to remove the element i // we can aslo use stack push pop hre 
        return false;
    }


    public static Node lowestCommonAncestor(Node root,int n1,int n2){  //O(n)

        ArrayList<Node> N1Path= new ArrayList<>();  // 1 2 4
        ArrayList<Node> N2Path= new ArrayList<>();  // 1 3 6 

        getPath(root, N1Path, n1);
        getPath(root, N2Path, n2);

        int i=0;
        for(;i<N1Path.size()&&i<N2Path.size();i++){

            if (N1Path.get(i).data!=N2Path.get(i).data) {  // we need to return the last Lowest last Comman Ancestor 
                break;                                      //which always present before the the non comman node
            }
        }

        /*
         *   1
         *  2!=3  break;
         *  return 1;
         * 
         */

        return N1Path.get(i-1); // coz i is incremented return 1

    }

    public static Node otimumLowestCommonAncestor(Node root,int n1,int n2){  //O(n) no extra space used

        //if (root==null ) return null; intigarted in below condition 

        if (root== null || root.data==n1||root.data==n2) { // if n1 or n2 found retun that nide 
            return root;
        }

        Node leftN=otimumLowestCommonAncestor(root.left, n1, n2);  // check the given node is present in left or right
        Node rightN=otimumLowestCommonAncestor(root.right, n1, n2);

        if (rightN==null) {  // if it found left side mens is right null 
            return leftN;    // and return left
        }

        if (leftN==null) {  // if it found right side mens is left null 
            return rightN;    // and return right
        }



        // if (leftN!=null && rightN!=null) {   // that mens the node have resived left(n1) and right(n2)
        //                                     // and cur node is CommonAncestor 
        //     return root;
        // } // that we not need to handle coz remaing we handled

        return root;   

    }   // do dry run for understanding
    
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

        // System.out.println(lowestCommonAncestor(root, 4, 5).data);
        // System.out.println(lowestCommonAncestor(root, 4, 6).data);

        System.out.println(otimumLowestCommonAncestor(root, 4, 6).data);
        System.out.println(otimumLowestCommonAncestor(root, 4, 5).data);

        
    }
}
