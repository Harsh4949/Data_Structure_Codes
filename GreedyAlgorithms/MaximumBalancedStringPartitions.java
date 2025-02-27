package GreedyAlgorithms;

public class MaximumBalancedStringPartitions {
    
    public static int  maximumBalecedSubstrings(String str){

        int L=0,R=0;
        int count=0;

        for (int i = 0; i < str.length(); i++) {
            
            char ch=str.charAt(i);

            if (ch=='L')
                L++;
            else
                R++;
                
            if (L==R) {
                count++;
                L=R=0;
            }
        }

        return count;
        
    }

    public static void main(String[] args) {
        
        String str="LRRRRLLRLLRL";

        System.out.println(maximumBalecedSubstrings(str));
    }


}
