package BasicProgram;
import java.util.Scanner;

class leapYear{

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();

        if(year%4==0 && (year%100!=0||(year%100==0 &&year%400==0))){

            System.out.println("Leap year...");
        }else{
            System.out.println("Not Leap Year...");
        }
        sc.close();
    }
}