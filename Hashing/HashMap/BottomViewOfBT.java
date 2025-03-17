
import java.util.*;

import org.junit.platform.engine.support.hierarchical.Node;

public class BottomViewOfBT {

    static class Node{

        int data;
        Node left;
        Node right;
        int hd ;   // horizonytal distace from middle line see in picture    -2 -1 0 1 2 for each root

        public Node(int data){

            this.data=data;
        }   
    }

    static HashMap<Integer,Integer> map;

    public static void helper(Node root){  // same BSF logic traversal

        Queue<Node> q= new LinkedList<>();
        
        q.add(root);
        root.hd=0;


        while (!q.isEmpty() && root!=null) {
            
            Node cur=q.poll();
            int index=cur.hd;

            map.put(index, cur.data);

            if (cur.left!=null) {

                Node Left =cur.left;
                Left.hd=index-1;        // if goes left then Hd goes minus
                q.add(Left);
            }

            if (cur.right!=null) {

                Node Right =cur.right;
                Right.hd=index+1;        // if goes right then Hd goes +Ve
                q.add(Right);
            }
        }   
    }

    public static ArrayList<Integer> bottomViewOfBT(Node root){

        map = new HashMap<>();  // map initialize to make fresh whenever call helper

        ArrayList<Integer> arrkeys =new ArrayList<>();
        ArrayList<Integer> arrresult =new ArrayList<>();

        helper(root);


        for (int key : map.keySet()) {   // [0, -1, 1, -2, 2]  see image tree hd values 
            arrkeys.add(key);
        }

        Collections.sort(arrkeys);      //[-2, -1, 0, 1, 2]  // to make output coorectly

        for (Integer val : arrkeys) {
            arrresult.add(map.get(val));
        }

        return arrresult;       //[5, 10, 3, 14, 25] correct output

    }

    public static void main(String[] args) {


        /*               20
                       /    \
         *           8       22
         *         /  \         \
         *       5      3         25
         *            /   \ 
         *           10    14
         */
        
        Node root = new Node(20);

        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right = new Node(22);
        root.right.right = new Node(25);

        System.out.println(bottomViewOfBT(root));
    }
}