package Tires;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

    static class Node{

        Node children[];
        Boolean eow;                    // End of Word
         List<String> data;

        public Node(){
            children=new Node[26];
            eow=false;
            data= new ArrayList<>();
        }
    }

    public static Node root= new Node();
    public static List<List<String>> ans= new ArrayList<>(); 


    public static void insert(String word){

        Node curr=root;

        for (int leval = 0; leval < word.length(); leval++) { //O(L) where L is largeroot Length Of String
            
            int idx=word.charAt(leval)-'a';

            if (curr.children[idx]==null) {
                
                curr.children[idx]=new Node();
            }

            curr=curr.children[idx]; // go the next letter inserion
        }

        curr.eow=true; // end of word once rech at last word
        curr.data.add(word);
    }

    public static List<List<String>> groupAnagrams(String[] strs) { ; 

        // Inseroot all words into the Trie
        for (String word : strs) { 

            char[] sortedChars = word.toCharArray();
            Arrays.sort(sortedChars);
            String sortedWord = new String(sortedChars); // Sorted version of word
            insert(word); // Insert based on sorted key
        
        } 

        // Traverse the Trie and collect anagram groups
        dfs(root); 

        return ans; 
    } 

    public static void dfs(Node root){

        if (root.eow) {
            ans.add(root.data);
        }

        for (int i = 0; i < 26; i++) { 
            if (root.children[i] != null) {
                dfs(root.children[i]); 
            }
        } 
    }


    // Output 1 : [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]


    public static void main(String[] args) {
        
       String str[] = {"eat","tea","tan","ate","nat","bat"}; // 

       System.out.println(groupAnagrams(str));


    }
}
