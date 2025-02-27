package ArrayList;

import java.util.ArrayList;

public class WaterContainer {
    
    
    public static int waterContainer(ArrayList height) {  //Brute force O(n^2)
        int maxwater=0;

        for(int i=0;i<height.size();i++){

            for(int j=i+1;j<height.size();j++ ){

                int minheight = Math.min((int)height.get(i), (int)height.get(j));
                int width = j-i;
                maxwater=Math.max(maxwater,width*minheight);

            }
        }

        return maxwater;
    }

    public static int maxwaterContainer(ArrayList height) { //Optimum O(n) Two pointer Approch
        int maxwater=0;

        int lp=0;                   //left pointer
        int rp=height.size()-1;     //right pointer

        while (lp<rp) {
            
            int minheight=Math.min((int)height.get(lp),(int)height.get(rp));
            int width=rp-lp;
            maxwater=Math.max(maxwater, minheight*width);

            if ((int)height.get(lp)<(int)height.get(rp)) 
                lp++;
            else
                rp--;
        }

        return maxwater;
    }

    public static void main(String[] args) {
    
        ArrayList<Integer> height=new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(height);
        System.out.println(waterContainer(height));
        System.out.println("optimum sol :" +maxwaterContainer(height));
         
       }
}

/*
 * [1, 8, 6, 2, 5, 4, 8, 3, 7]
 *  lp++-->               <-rp--
 */