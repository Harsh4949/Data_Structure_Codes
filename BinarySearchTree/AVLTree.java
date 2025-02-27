package BinarySearchTree;

import BinarySearchTree.BasicBST.Node;

public class AVLTree {
    
    static class Node {
    
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data){

            this.data=data;
            this.height=1;
        }
    }

    public static Node leftRotate(Node x){

        Node y=x.right;   // initialize as it is X,Y,T2 as per given diagram
        Node T2=y.left;


        // Now Update X,y,T2

        y.left=x;
        x.right=T2;        


        // Update Heights 


        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));

        return y;
    }

    public static Node rightRotate(Node y){  // refer Imgae "D:\Programming\vscodeProgram\BinarySearchTree\AVLLeftRightRotateLogic.png"
    
        // initialize as it is Y,X,T2 as per given diagram
       
        Node x=y.left;
        Node T2=x.right;

        // Now Update X,y,T2

        x.right=y;
        y.left=T2;

        // update heights 
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1; 
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1; 

        return x;
    }

    public static int getHeight(Node root){

        if (root==null) {
            return 0;
        }
        return root.height;  // we calculated each node height in insert function 
    }

    public static int getBalancedFactor(Node root){

        if (root==null) {
            return 0;
        }

        // return root.left.height-root.right.height;  if in case left and right is null then get problem
        return getHeight(root.left)-getHeight(root.right);
    }

    
    public static Node insert(Node root,int key){

        if (root==null) {               //if root is null which alwys when we insert element 
            
            return new Node(key);
        }

        //BT Logic

        if (key>root.data) {            //if data grater than right 
            
            root.right=insert(root.right, key);
        } 
        else if (key<root.data) {       //if data grater than right 
           
            root.left=insert(root.left, key);

        }else{                          //if duplicate / same value then not inserted return root as it is
                return root;
        }

        //Update height
        root.height= 1 + Math.max(getHeight(root.left), getHeight(root.right));

        //get Balence factor

        int bf=getBalancedFactor(root);       // tree is baleced if the height is 1 ,0,-1
                                              // bf>1 mens tree unblenced in left side
                                              // bf<-1 mens tree unblenced in right side

        //check the cases LL,RR,LR,RL 
        
        //LL case Root is inserted Left left side
                                                    //                              L          LL
        if ( bf>1 &&key<root.left.data) {          //  if bf>1 and it samller than root and root.left tree 
            
            return rightRotate(root);
        }  
                                                                //                                R          RR
        if ( bf<-1&&key>root.right.data) {       // RR case      //  if bf<-1 and it grater than root and root.right 
       
            return leftRotate(root);
        }

        if(bf>1 && key>root.left.data){ // LR Case  // if 1st L mens bf poitive and it unbalnced in left - right tree
        
            //rotate the last two nodes for fist L
            root.left=leftRotate(root.left);
            return rightRotate(root);    // rotate hole tree.
        }

        if(bf<-1 && key<root.right.data){ // RL Case  // if 1st R mens bf negative and it unbalnced in rigth - left tree
        
            //rotate the last two nodes for fist R

            root.right=rightRotate(root.right);
            return leftRotate(root);

        }
        

        return root;  // return root after changes are made if tree is alrady balenced 
    }


    public static void inorder(Node root){

        if (root==null) {
            return;
        }

        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);

    }


    public static void main(String[] args) {
        
        Node root=null;

        root = insert(root, 10); 
        root = insert(root, 20); 
        root = insert(root, 30); 
        root = insert(root, 40); 
        root = insert(root, 50); 
        root = insert(root, 25); 

        /*          
            AVL Tree 
                 30 
                / \ 
               20  40 
              / \   \ 
            10  25   50 
        */ 

        inorder(root);
        
        System.out.println(" \n "+getHeight(root));
        System.out.println(" \n "+getBalancedFactor(root));

    }
}
