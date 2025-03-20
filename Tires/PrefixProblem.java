package Tires;

import java.util.ArrayList;

public class PrefixProblem {
    
    static class Node{

        Node children[]=new Node[26];
        Boolean eow=false;                    // End of Word
        int freq;

        public Node(){
            for (int i=0;i<children.length;i++) {
                children[i] =null;
            }
            freq=0;
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

            curr.children[idx].freq++;
            curr=curr.children[idx]; // go the next letter inserion
        }

        curr.eow=true; // end of word once rech at last word
    
    }

    public static void findprefix(Node root ,String ans){

        if (root==null) {
            return;
        }

        if (root.freq==1) {  // root not  decteced duw to root freq=0
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) { // check all childern
            
            if (root.children[i]!=null) {
                
                findprefix(root.children[i], ans + (char)(i+'a'));   // in string + used to appending Not +=     
            }
        }
    }

    public static void main(String[] args) {
        
        String words[]={"zebra","dog","duck","dove"};

        for (int i = 0; i < words.length; i++) {
            
            insert(words[i]);
        }
        
        findprefix(root, "");
    }
}
