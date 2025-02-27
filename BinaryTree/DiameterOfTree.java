package BinaryTree;

public class DiameterOfTree {
    
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

    public static class BinaryTree{

        static int idx=-1;

        static int diamerter=0;

        public static Node bulidTree(int [] nodes){

            idx++;

            //base case

            if (nodes[idx]==-1) {
                return null;
            }

            //recursion

            Node root= new Node(nodes[idx]);  // root node , to add a Node 

            root.left=bulidTree(nodes);      // add node to the left side until found -1 null   
            root.right=bulidTree(nodes);  // add node to the right side until found -1 null  

            return root;
        }


        public static int heightTree(Node root){

            if (root==null) return 0;
            return Math.max(heightTree(root.left),heightTree(root.right))+1;

        }

        public static int diameterOfTree(Node root){   //O(N^2)  Not optimum For just Logic

            if (root==null)    return 0;
            
            int lh=heightTree(root.left);      //left height
            int ld=diameterOfTree(root.left);  // left diameter 

            int rh=heightTree(root.right);
            int rd=diameterOfTree(root.right);

            //where the diametr is total no. of nodes in left and right slide 

            int selfD= lh+rh+1; 

            return Math.max(Math.max(ld, rd),selfD); // which node have maximum diameter here we waana display

        }

        public static int diameterOfTree2(Node root){   //O(N^2)  Not optimum For just Logic

            if (root==null)    return 0;
            
            int lh=diameterOfTree(root.left);  // left diameter 
            int rh=diameterOfTree(root.right);

            //where the diametr is total no. of nodes in left and right slide 

            diamerter=Math.max(lh+rh+1,diamerter);

            return Math.max(lh,rh)+1; // which node have maximum diameter here we waana display

        }

        static class NodeInfo {
        
            int ht;
            int dia;

            public NodeInfo(int ht,int dia){

                this.ht=ht;
                this.dia=dia;
            }
        }


        public static NodeInfo OtimumDiameterOfTree(Node root){   //O(n)  // each node have one object

            if (root==null) {
                return new NodeInfo(0, 0);
            }

            NodeInfo leftInfo=OtimumDiameterOfTree(root.left);
            NodeInfo rightInfo=OtimumDiameterOfTree(root.right);

            int ht= Math.max(leftInfo.ht,rightInfo.ht)+1;
            int selfD=leftInfo.ht+rightInfo.ht+1;  //diametr is total no. of nodes in left and right slide 

            return new NodeInfo(ht, Math.max(Math.min(leftInfo.ht, rightInfo.ht),selfD)); //  node have maximum diameter ->display
        }
    }

    public static void main(String srgs[]){

        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        /*            1  
        *          2     3
        *        4   5     6
                             
        */    

        BinaryTree bt=new BinaryTree();

        Node root=bt.bulidTree(nodes);

        System.out.println(bt.diameterOfTree(root));
        System.out.println(bt.OtimumDiameterOfTree(root).dia);
        System.out.println(bt.OtimumDiameterOfTree(root).ht);

        bt.diameterOfTree2(root);
        System.out.println(bt.diamerter);
    }
}
