package BitManipulaiton;

import Stringque.replaceWithString;

public class getSetClearUpdateithBit {

    public static int getithBit(int num,int i){
        
                            //00001111
        int bitMask=1<<i;  // 00000100 -> it shits the one at perticuler position


        if((num & bitMask)== 0){      // 00000100  //perform the ANDing 

            return 0;

        }else{

            return 1;
        }

    }

    public static int setithBit(int num,int i){

        int bitMask=1<<i;   //0010

       return num|bitMask; 

    }

    
    public static int clearithBit(int num,int i){
        
        int bitMask=~(1<<i);        //(0100)----> ~(1011)
        
       return num&bitMask; 

    }

    public static int updateithBit(int num,int i,int bit){
        
        
        // if(bit==1)
        //     return setithBit(num, i);
        // else
        //     return clearithBit(num, i);


        int n= clearithBit(num, i);     // 0111(7)---->(0101)(5) // first clear the bit then add it 

        int bitMask=bit<<i; 
       
        return n|bitMask; 

    }

    public static int clearLastithBit(int num,int lbit) {
        
        int bitMask=~(0)<<lbit;  //~0==-1==1111111111111111 left shift shifts bits by Zeros(0's) 
        
        return num&bitMask;
    }

    public static int clearRangeiTojthBit(int num,int i,int j) {
                                    //         15     2     4
                            //15 00001111

        int a=(1<<i)-1;                //  00000011
        int b=~(0)<<(j+1);            //   11111000
        
        int bitMask=a|b;               //  11111011
        
        return num&bitMask;     

        // see logic in ss
    }


    public static boolean isPowerOfTwo(int num){

        return (num &(num-1))==0;   //check condition see logic in ss
    }

    public static void main(String[] args) {

        int num=15;          //0000001111
        int i=2;
        int bit=0;
        int lbit=2;
        int j=4;

        // System.out.println(getithBit(num,i));
        // System.out.println(setithBit(num, i));
        //System.out.println(ClearithBit(num, i));
        //System.out.println(updateithBit(num, i, bit));
        //System.out.println(clearLastithBit(num, lbit));
        //System.out.println(clearRangeiTojthBit(num,i,j));
          System.out.println(isPowerOfTwo(8));
    }
    
}
