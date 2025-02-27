package BasicProgram;

public class FessBuss
{
	public static void main(String[] args) {
		
		int no=55;
		
		if(no%15==0){
		    System.out.println("FessBuss");
		}
		else if(no%3==0||no%5==0){
		    
		   System.out.println( no%3==0 ? "Fess" :"buss");
		}
		else{
		      System.out.println(no);
		}

	}
}