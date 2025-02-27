package BitManipulaiton;

public class EvenOddNo {

public static boolean checkEvenOddNo(int num) {

    int bitmask=1;

    if((num & bitmask)==0){
        return true;
    }

    return false;
}
    public static void main(String[] args) {

        int num=4;      //0100

        System.out.println(checkEvenOddNo(num));
    }
}

/*
    here we perform ANDing of num & 1
    00001111
    00000001
    -----------
    00000001 ->odd

    0-> Even 
    1-> odd

 */ 