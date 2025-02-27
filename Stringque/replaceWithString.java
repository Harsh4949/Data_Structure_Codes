package Stringque;


public class replaceWithString{

    public static void main(String args[]){         //it works only when String initialiazation state.

        String str = "ApnaCollege".replace("l", "X");  
        String str1="ApnaCollege";

        str.replace("l", "X");      //Not working bcoz String is immutable
        
        System.out.println(str+" "+str1);

    }
}