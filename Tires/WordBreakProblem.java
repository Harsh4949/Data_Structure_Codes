package Tires;

import Stringque.stringAlagram;

public class WordBreakProblem {
    
    static class Node {
    
        Node childern[]= new Node[26]; //"a"-"z"
        Boolean eow;

        public Node(){
            
            for (int i = 0; i < childern.length; i++) {
                
                this.childern[i]=null;
                this.eow=false;
            }
        }
    }
        public static Node root= new Node();

        public static void insert(String word){

            Node curr=root;

            for (int i = 0; i < word.length(); i++) {
                
                int idx=word.charAt(i)-'a';

                if (curr.childern[idx]==null) {
                    curr.childern[idx]=new Node();
                }
                curr=curr.childern[idx];
            }

            curr.eow=true;
        }

        public static Boolean search(String word){

            Node curr=root;

            for (int i = 0; i < word.length(); i++) {
                
                int idx=word.charAt(i)-'a';

                if (curr.childern[idx]==null) {
                   return false;
                }
                curr=curr.childern[idx];
            }

            return curr.eow==true;
        }

        public static Boolean wordBreak(String word){

            if (word.length()==0) {
                return true;
            }

            for (int i = 1; i <= word.length(); i++) { // to handle 0-0 in subtring
            
                System.out.print(word.substring(0, i)+ " "); 
                System.out.println(word.substring(i)); 

                // if 1st Condition is true then only and only wordBreak(word.substring(i)) 2nd is check

                if (search(word.substring(0, i)) && wordBreak(word.substring(i))) {
                    return true;
                }
            }

            return false;
        }
                 
     

    public static void main(String[] args) {
        
        String words[]={"i","like","sum","samsung","mobile","ice"};
        String key="ilikesamsung";
        
        for (String string : words) {
            insert(string);
        }

        System.out.println(wordBreak(key));
        //System.out.println(wordBreak("ilikeg"));
    }
}
