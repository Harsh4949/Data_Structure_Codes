package BasicProgram;
import java.util.Scanner;

public class GMT_INR_Converter
{
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		

    	int dayNumber=sc.nextInt();
		int hourNumber=sc.nextInt();
		int minuteNumber=sc.nextInt();


        hourNumber+=5;
        minuteNumber+=30;


        if(dayNumber>=30){
            dayNumber-=30;
        }

        if(hourNumber>=24){
            dayNumber++;
            hourNumber-=24;
        }

        if(minuteNumber>=60){
            hourNumber++;
            minuteNumber-=60;
        }
		System.out.println("Day : "+dayNumber+", Hour : "+hourNumber+", Minute : "+minuteNumber);
        sc.close();

	}
    
}

//This code is only for reverse the timeline 
