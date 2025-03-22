package Tires;

public class UniqueSubstrings {   // Nootbook Page 16 Jan 2025

    static class Node {

        Node childern[]=new Node[26];
        Boolean eow=false;

        public Node(){

            for (int i = 0; i < childern.length; i++) {
                childern[i]=null;
            }
        }
    }

    public static Node root= new Node();

    public static void insert(String word){

        Node cur= root;

        for (int i = 0; i < word.length(); i++) {
            
            int idx= word.charAt(i)-'a';
            if (cur.childern[idx]==null) {
                cur.childern[idx]= new Node();
            }
            cur=cur.childern[idx];
        }
        cur.eow=true;
    }

    public static int countNode(Node root){

        if (root == null) {
           return 0;
        }

        int count =0;

        for (int i = 0; i < 26; i++) {
            
            if (root.childern[i]!=null) {                   // go call for only not null value
                count+=countNode(root.childern[i]);
            }
        }
        return count+1;  // like bst when reach at end of tree then do +1 evry stage during bactracking
    }
    
    public static void main(String[] args) {   // see ScreenShot For more understnading
        
        String str="ababa";     // 10

        // 1> we need to find all sufix of string add it in Trie 

        for (int i = 0; i < str.length(); i++) {
            
            insert(str.substring(i));                   // as shown in given image 
        }

        //Count No of nodes in Trie

        System.out.println(countNode(root)); 

    }
}
