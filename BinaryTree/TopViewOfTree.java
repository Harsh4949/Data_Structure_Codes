package BinaryTree;

import java.util.*;

public class TopViewOfTree {
   
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

    static class NInfo{
        
        Node node;
        int hd; // horizontal distance  were root having 0   left elemnt -ve right positive +ve
                // -2 -1 0 1 2 3 

        public NInfo(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topViewTree(Node root){

        Queue<NInfo> bfs=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        int min=0,max=0;
        bfs.add(new NInfo(root, 0));
        bfs.add(null);

        while (!bfs.isEmpty()) {
            
            NInfo curNode= bfs.poll();

            if (curNode==null) {

                if (bfs.isEmpty()) 
                        break;  // if the size of queue is 0 ie. empty then exit   
                else 
                    bfs.add(null);   // add null that represent new level start
       
            } else {

                if (!map.containsKey(curNode.hd)) {  // if key not exits then return false we use ! to execute block
                    
                    map.put(curNode.hd, curNode.node);
                }

                if (curNode.node.left!=null) {
                    bfs.add(new NInfo(curNode.node.left, curNode.hd-1));
                    min=Math.min(max, curNode.hd-1);
                }
                
                if (curNode.node.right!=null) {
                    bfs.add(new NInfo(curNode.node.right, curNode.hd+1));
                    max=Math.max(max, curNode.hd+1);
                }
            }
        }

        for(int i = min; i <=max; i++) {
            
            System.out.print(" "+map.get(i).data);
        }
        System.out.println();

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

        topViewTree(root);

    }
}
