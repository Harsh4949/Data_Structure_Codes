
package BinarySearchTree;

public class SizeofLargestBSTInBT {  // see logic in "D:\Programming\vscodeProgram\BinarySearchTree\SizeofLargestBSTInBTLogic.png"
    
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
        int size;
        int min;
        int max;

        public nodeInfo(Boolean isBalenced,int size,int min,int max){

            this.isBalenced=isBalenced;
            this.size=size;
            this.min=min;
            this.max=max;
        } 
    }

    public static int maxBSTSize=0;

    public static nodeInfo findMaxSizeBSTInBT(Node root){

        if (root==null) {
            return new nodeInfo(true,0 , Integer.MAX_VALUE,Integer.MIN_VALUE );
        }

        nodeInfo leftInfo=findMaxSizeBSTInBT(root.left);
        nodeInfo rigthInfo=findMaxSizeBSTInBT(root.right);
        
        // calculate self info size, min ,max , isbalenced

        int size=1+leftInfo.size+rigthInfo.size;

        int min=Math.min(root.data,Math.min(leftInfo.min, rigthInfo.min));  // we check min value here coz we use Integer.MAX_VALUE 

        int max=Math.max(root.data,Math.max(leftInfo.max, rigthInfo.max));  

            
        // Check if the current subtree is a BST
        if (leftInfo.max>=root.data || rigthInfo.min<=root.data) {   // reverse logic to retuen false
            
            return new nodeInfo(false, size, min, max);
        }

         // If both left and right subtrees are BSTs, then the current tree is a BST
        if (leftInfo.isBalenced && rigthInfo.isBalenced) {

            maxBSTSize=Math.max(maxBSTSize, size);        // not calculate if BST is false 
            return new nodeInfo(true, size, min, max);
        }
       
        // If the current tree is not a BST, return false
        return new nodeInfo(false, size, min, max);
    }
    

    public static void main(String[] args) {

        Node root =new Node(60);

        root.left=new Node(45);
        root.right=new Node(70);
        
        root.right.left=new Node(65);
        root.right.right=new Node(80);

        nodeInfo info=findMaxSizeBSTInBT(root);

        //System.out.println(info.size);
        System.out.println(info.isBalenced);
        System.out.println(maxBSTSize);
    }
}
