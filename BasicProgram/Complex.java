package BasicProgram;

import java.util.concurrent.CompletionService;

public class Complex {
    
    int real,imag;

    public Complex(int real,int imag){

        this.imag=imag;
        this.real=real;
    }

    public static Complex add (Complex c1, Complex c2){

        return new Complex((c1.real+c2.real), (c1.imag+c2.imag));
    }

    public static Complex diff (Complex c1, Complex c2){

        return new Complex((c1.real-c2.real), (c1.imag-c2.imag));
    }

    public static Complex product (Complex c1, Complex c2){

        return new Complex((c1.real*c2.real), (c1.imag*c2.imag));
    }

    public void print(){

        if(real==0 && imag!=0){
            System.out.println(imag+"i");
        }

        else if(real!=0 && imag==0){
            System.out.println(real);

        }
        else{
                System.out.println(real+" + "+imag+"i");
        }
             
            
    }


    public static void main(String[] args) {
        
        Complex c1= new Complex(5, 1);
        Complex c2= new Complex(4, 1);

        Complex c3=add(c1,c2);
        Complex c4=diff(c1,c2);
        Complex c5=product(c1,c2);

        c1.print();
        c2.print();;
        c3.print();
        c4.print();
        c5.print();
    }
}
