package Stringque;

public class NoOFLowerCaseVowals{

    public static int countLowercaseVowals(String str) {
        int count=0;
        
        for(int i=0;i<str.length();i++){

            if(Character.isLowerCase(str.charAt(i))==true){

                if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){

        String str="AEiou";

        System.out.println(countLowercaseVowals(str));
    }
}