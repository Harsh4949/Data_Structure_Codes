package BasicProgram;
import java.util.Scanner;

public class weekday
{
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int dayNo=sc.nextInt();
		
		switch(dayNo){

			case 1 : 		
            case 2 : 		
            case 3 : 		
            case 4 :		
            case 5 : System.out.println("WeekDay");
							break; 

			// case 1,2,3,4,5 : System.out.println("Weekday");
			// 				break;
            // Multi-constant case labels supported from Java 14 onwards only

            case 6 :
			case 7 : System.out.println("Weekend");
							break;
			default : System.out.println("error");					

		}

		sc.close();
	}
}