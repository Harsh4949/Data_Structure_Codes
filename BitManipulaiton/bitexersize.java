package BitManipulaiton;

class bitexersize{


    public static void main(String[] args) {
        
        int x = 6; 
        System.out.println(x + " + " + 1 + " is " + -~x); 
        x = -4; 
        System.out.println(x + " + " + 1 + " is " + -~x); 
        x = 0; 
        System.out.println(x + " + " + 1 + " is " + -~x);


        int y = 4; 

        System.out.println("Before swap: x = " + x + " and y = " + y); 
        //swap using xor 
        x = x ^ y; 
        y = x ^ y; 
        x = x ^ y; 
        System.out.println("After swap: x = " + x + " and y = " + y);


         // Convert uppercase character to lowercase 

        for (char ch = 'A'; ch <= 'Z'; ch++) { 

             System.out.println((char)(ch | ' '));     // prints abcdefghijklmnopqrstuvwxyz 
        }

        System.out.println((char)('H'|' ' ));


    }
}

// xor property : X^X = 0  and X^0 = X
//only return one if both values are same...