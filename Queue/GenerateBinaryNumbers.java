package Queue;
import java.util.*;
public class GenerateBinaryNumbers {
    
    public static void generatePrintBinary(int n){

        Queue<String> queue=new LinkedList<>();

        queue.add("1");     // initialy we gwtting 1 coz. we geeting it s1

        for(int i=0;i<n;i++){       // n = 2

            String s1=queue.peek();         //s1=1 10 11 100 101 
            queue.remove();

            System.out.print(" "+ s1);   // 1 

            String s2=s1;            // 1 10 
        
            //first we adding one so add zero for combination

            queue.add(s1+"0");     // q= 10 100 101-peek
            queue.add(s2+"1");     // q= 11 101 

        }

    }


    public static void main(String[] args) {
        
        generatePrintBinary(5); 
    }
}
