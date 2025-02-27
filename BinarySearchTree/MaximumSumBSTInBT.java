package BinarySearchTree;

public class MaximumSumBSTInBT {

    static class Node {
    
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }

  

    static class nodeInfo{

        Boolean isBalenced;
        int sum;
        int min;
        int max;

        public nodeInfo(Boolean isBalenced,int sum,int min,int max){

            this.isBalenced=isBalenced;
            this.sum=sum;
            this.min=min;
            this.max=max;
        } 
    }

    public static int maxBSTSum=0;

    public static nodeInfo findMaxSizeBSTInBT(Node root){

        if (root==null) {
            return new nodeInfo(true,0 , Integer.MAX_VALUE,Integer.MIN_VALUE );
        }

        nodeInfo leftInfo=findMaxSizeBSTInBT(root.left);
        nodeInfo rigthInfo=findMaxSizeBSTInBT(root.right);
        
        // calculate self info size, min ,max , isbalenced

        int sum=root.data+leftInfo.sum+rigthInfo.sum;

        int min=Math.min(root.data,Math.min(leftInfo.min, rigthInfo.min));  // we check min value here coz we use Integer.MAX_VALUE 

        int max=Math.max(root.data,Math.max(leftInfo.max, rigthInfo.max));  

            
        // Check if the current subtree is a BST
        if (leftInfo.max>=root.data || rigthInfo.min<=root.data) {   // reverse logic to retuen false
            
            return new nodeInfo(false, sum, min, max);
        }

         // If both left and right subtrees are BSTs, then the current tree is a BST
        if (leftInfo.isBalenced && rigthInfo.isBalenced) {

            maxBSTSum=Math.max(maxBSTSum, sum);        // not calculate if BST is false 
            return new nodeInfo(true, sum, min, max);
        }
       
        // If the current tree is not a BST, return false
        return new nodeInfo(false, sum, min, max);
    }
    

    public static void main(String[] args) {

       /*
        * Sample Input 1 : 

                                 5 
                                / \ 
                               9    2 
                              /      \ 
                             6        3
                            / \ 
                           8   7 
                                 

          Sample Output 1 : 8 
        */
       
        Node root =new Node(5);

        root.right=new Node(2);
        root.right.right=new Node(3);

        root.left=new Node(9);
        root.left.left=new Node(6);

        root.left.left.right=new Node(7);
        root.left.left.left=new Node(8);

        nodeInfo info=findMaxSizeBSTInBT(root);

        //System.out.println(info.size);
        //System.out.println(info.isBalenced);
        System.out.println(maxBSTSum);
    }
}