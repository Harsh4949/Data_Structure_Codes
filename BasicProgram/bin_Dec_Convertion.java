package BasicProgram;

public class bin_Dec_Convertion{

    public static void binToDec(int binNo){

        int no=binNo;
        int pow=0;
        int decNo=0;
        int lastNo;

        while(binNo>0){

           lastNo= binNo%10;
           decNo=decNo+lastNo*(int)Math.pow(2,pow);
           binNo=binNo/10;
           pow++;
        }
        System.out.println("Decimal No of "+no+" : "+decNo);
    }

    public static void decToBin(int decNo){

        int no= decNo;
        int pow=0;
        int binNo=0;
        

        while(decNo>0){
        
            int rem=decNo%2;
            binNo=binNo+(rem*(int)Math.pow(10,pow));
            decNo=decNo/2;
            pow++;
        }
        System.out.println("Binary No of "+no+" : "+binNo);
    }

    public static void main(String args[]){

        decToBin(10);

    }
}