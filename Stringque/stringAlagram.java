package Stringque;

public class stringAlagram{

public static boolean checkStringAlagram(String str1,String str2){

    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    int str1AsciiVal=0;
    int str2AsciiVal=0; 

    if(str1.length()!=str2.length()){
        
        return false;

    }else{

        for(int i=0;i<str1.length();i++){       //both string length must be same i may value differ. 

            str1AsciiVal+=str1.charAt(i);       //addition of ascci value of both string.
            str2AsciiVal+=str2.charAt(i);

        }

        if(str1AsciiVal==str2AsciiVal){
            return true;
        }        
    }

    return false;
}

    public static void main(String args[]){

        String str1="wal7@wa";
        String str2="Wa7l@wa";

        System.out.println(checkStringAlagram(str1, str2));
    }
}