package Tires;

import java.util.List;

public class LongestWordWithAllPrefixes {
    
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

    public static String ans=" ";

    public static  void longestWordWithAllPrefixes(Node root,StringBuilder temp){

        if(root==null){
            return;
        }

        for (int i = 0; i < 26; i++) {
            
            if (root.childern[i]!=null && root.childern[i].eow==true) {  // the string have all eow is true
                temp.append((char)(i+'a'));

                if (temp.length()>ans.length()) {  // for arrageing as per alphabatically/Laxicograpycally
                    ans=temp.toString();
                }

                System.out.println("in : "+temp);

                longestWordWithAllPrefixes(root.childern[i], temp);
                //remove character backtrack
                
               temp.deleteCharAt(temp.length()-1); // delete last char
            }
        }
       
    }

    public static void main(String[] args) {
        
        String words[]={"a","banana","app","appl","apply","ap","apple"};

        for (String string : words) {
            insert(string);
        }
        
        longestWordWithAllPrefixes(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
