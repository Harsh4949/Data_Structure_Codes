package Tires;

public class StartsWithProblem {
    
    static class Node{

        Node children[]=new Node[26];
        Boolean eow=false;                    // End of Word

        public Node(){
            for (int i=0;i<children.length;i++) {
                children[i] =null;
            }
        }
    }

    public static Node root = new Node(); // initialize 26 characters and eow

    public static void insert(String word){

        Node curr=root;

        for (int leval = 0; leval < word.length(); leval++) { //O(L) where L is largert Length Of String
            
            int idx=word.charAt(leval)-'a';

            if (curr.children[idx]==null) {
                
                curr.children[idx]=new Node();
            }

            curr=curr.children[idx]; // go the next letter inserion
        }

        curr.eow=true; // end of word once rech at last word
    
    }

    public static Boolean search(String word){  // O(L)

        Node curr= root;

        for (int i = 0; i < word.length(); i++) {
            
            int idx=word.charAt(i)-'a';

            if (curr.children[idx]==null) {
                return false;
            }
           
            curr=curr.children[idx];
            
        }    
        
        return true;
    }

    public static void main(String[] args) {
        
        String words[]={"apple","app","mango","man","woman","thee"};

        for (int i = 0; i < words.length; i++) {
            
            insert(words[i]);
        }

        System.out.println(search("app"));
        System.out.println(search("moon"));
        
    }
}
