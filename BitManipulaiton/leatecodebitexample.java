package BitManipulaiton;

public class leatecodebitexample {
    
    // we have given non-empty array we need to find the sigle number witch does not repeted 
     
    public static int singleNumber(int nums[]){

        int result=0;

        for(int i=0;i<nums.length;i++)
                result^=nums[i];

        return result;
    }

    //number of bits reqire to flip to get given number...

    public static int flipbitcount(int num1,int num2) {
         
        int n=num1^num2;

        int setbitcount=0;

        while(n!=0){  
                             
            n =n &(n-1);      //vvimp to count number of set bits...
            setbitcount++;
        }


        return setbitcount;
    }



    public static void main(String[] args) {

        int numaary[]={12,34,34,56,32,32,56};
        
        System.out.println(singleNumber(numaary));
       
        System.out.println(flipbitcount(2, 4));
    }

}

// xor property : X^X = 0  and X^0 = X
//only return ZERO if both values are same...