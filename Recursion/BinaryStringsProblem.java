package Recursion;

public class BinaryStringsProblem {
    
    public static void printNotConsecativeOnes(int n,int LastDigit ,String str) {
        
        if (n==0) {
            System.out.println(str);
            return;
        }
            
        //Simplified Version of below code

        printNotConsecativeOnes(n-1, 0, str+"0");

        if (LastDigit==0) {
            printNotConsecativeOnes(n-1, 1, str+"1");
        }
        
    }

    public static void printNotConsecativeZeros(int n,int LastDigit ,String str) {
        
        if (n==0) {
            System.out.println(str);
            return;
        }
            
        //Simplified Version of below code

        printNotConsecativeZeros(n-1, 1, str+"1");

        if (LastDigit==1) {
            
            printNotConsecativeZeros(n-1, 0, str+"0");
        }
        
    }

    public static void main(String[] args) {
        printNotConsecativeOnes(3, 0, "");
       // printNotConsecativeZeros(3, 1, "");
    }
}

//here we check the last digit of the number if it's 0 then we can put next number 0 or 1 
//if 1 then we can put only zero

        // if (LastDigit==0) {
        //     printNotConsecativeOnes(n-1, 0, str+"0");
        //     printNotConsecativeOnes(n-1, 1, str+"1");
        // }else
        //     printNotConsecativeOnes(n-1, 0, str+"0");