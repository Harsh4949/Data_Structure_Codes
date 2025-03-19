package BinarySearchTree;

public class PopulatingNextRightPointersEachNode {  // LogicON  [13 janury 2025] NootBOOK 
    

    public class Node{
        
        Object data;
        Node next;
        Node left;
        Node right;

        public Node(Object data){

            this.data=data;
        
        }
    }

    public Node connect(Node root) {

        if(root==null) return root;

       Node left_level_Dn=root;

       while(left_level_Dn!=null){

        Node cur_right_move=left_level_Dn;

            while(cur_right_move!=null){

                if(cur_right_move.left!=null){

                    cur_right_move.left.next=cur_right_move.right;
                }

                if(cur_right_move.right!=null && cur_right_move.next!=null){

                    cur_right_move.right.next=cur_right_move.next.left;

                }
                    
                cur_right_move=cur_right_move.next;
            }

            left_level_Dn=left_level_Dn.left;        
       }
        
        return root;

    }

    public static void main(String[] args) {
        
       
    }
}
