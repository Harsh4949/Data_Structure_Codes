package Recursion;

public class TailingPorbleam {

    public static int tailingSolution(int n) {
                                // ex : 6
        if (n==0 ||n==1) 
            return 1;
        
            //             vertical           Horizontal
        return tailingSolution(n-1)+tailingSolution(n-2);


        //for solving this we need to consider 3 points
        // 1> base/ exit condition
        // 2> option vertical or Horizontal
        // 3> return addition...

        /*
          tailingSolution(6) = tailingSolution(5) + tailingSolution(4) = 8
          tailingSolution(5) = tailingSolution(4) + tailingSolution(3) = 7
          tailingSolution(4) = tailingSolution(3) + tailingSolution(2) = 5
          tailingSolution(3) = tailingSolution(2) + tailingSolution(1) = 3
          tailingSolution(2) = tailingSolution(1) + tailingSolution(0) = 1
                                                                        ----
                                                                         13   
         */

    }


    public static void main(String[] args) {
        
        System.out.println(tailingSolution(6));
    }
}
