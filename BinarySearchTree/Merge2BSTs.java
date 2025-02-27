package BinarySearchTree;

import java.util.ArrayList;

import BinarySearchTree.BasicBST.Node;

public class Merge2BSTs {


    public static void inorderSeq(Node root,ArrayList<Integer> arr){

        if (root==null) {
           return ;
        }

        inorderSeq(root.left,arr);
        arr.add(root.data);
        inorderSeq(root.right,arr);

    }

    public static void inorder(Node root){

        if (root==null) {
           return;
        }

        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);

    }

    public static Node createBST(ArrayList<Integer> arr,int si,int ei){

        if (si>ei) {            //*** remaimber
            return null;
        }

        int mid =(si+ei)/2;

        Node root=new Node(arr.get(mid));

        root.left=createBST(arr, si, mid-1);
        root.right=createBST(arr, mid+1, ei);

        return root;
    }

    public static Node merger2BST(Node BST1,Node BST2){

        
        ArrayList <Integer> inorder1=new ArrayList<>();
        ArrayList <Integer> inorder2=new ArrayList<>();
        ArrayList <Integer> finalIn=new ArrayList<>();

        // get the two BST,s Inorder

        inorderSeq(BST1, inorder1);
        inorderSeq(BST2, inorder2);

        // merge Two BST inorder In One sorted Arry

        int i=0,j=0;

        while (i<inorder1.size()&&j<inorder2.size()) {
            
            if (inorder1.get(i)<=inorder2.get(j)) {
                
                finalIn.add(inorder1.get(i));
                i++;

            }else{

                finalIn.add(inorder2.get(j));
                j++;
            }
        }

        while (i<inorder1.size()) {
            finalIn.add(inorder1.get(i));
            i++;
        }

        while (j<inorder2.size()) {
            
            finalIn.add(inorder2.get(j));
            j++;
        }

        Node mergerdBST=createBST(finalIn, 0, finalIn.size()-1);


        return mergerdBST;
 
    }
      
    public static void main(String[] args) {
        
        /*
         *           2
         *        1     4
         */
        
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

         /*
         *           9
         *        3    12
         */
        
         Node root2=new Node(9);
         root2.left=new Node(3);
         root2.right=new Node(12);


        Node mergerdBST=merger2BST(root1, root2);      //1 2 3 4 9 12   si= 0   ei =5
 
        inorder(mergerdBST);
        
         /*
         *            3
         *        1       9
         *          2   4   12
         */
        

    }
}
