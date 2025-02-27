package Queue;

import java.util.*;

public class FirstNonRepetingCharacter {
    
    public static void firstNonRepetingChar(String str){

        int []freqarry=new int[26];   // first we need to create the frequency arry form a-z

        Queue<Character> q=new ArrayDeque<>();

        //evaluate string

        for(int i=0;i<str.length();i++){

            freqarry[str.charAt(i)-'a']++;
            q.add(str.charAt(i));

            while (!q.isEmpty()&&freqarry[q.peek()-'a']>1) {        //remove elemnts that have frequncy Grater than 1
                q.remove();
            }

            if (q.isEmpty()) {     // while doing this if q is empty then retuen -1
                System.out.println(" -1");
            }
            else{
                System.out.println(" "+q.peek());       // else print the top elelment
            }
          
        }
    }


    public static void main(String[] args) {
        
        firstNonRepetingChar("aadccxd");
    }
}


/*
 * 
 * 
 * 
 * refer diagram for debug..  ;-  Queue/FirstNonRepetingCharacter.png
 * 
 * 
 */
