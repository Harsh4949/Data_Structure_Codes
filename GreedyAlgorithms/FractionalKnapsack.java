package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    
    public static int maximumTotalValue(int[]value,int[]weight,int capacity){

        int totalValue=0;

        //first we need create arry with ratio, value ,weight
    
        double[][]ratio=new double[weight.length][2];

        for (int i = 0; i < weight.length; i++) {
            
            ratio[i][0]=i;                            //index of value and weight
            ratio[i][1]=(double)(value[i]/weight[i]); //ratio  [6,5,4]
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1])); // sort the arry as per ratio

       //sorting done by asending order we need to pick that have grater ratio
       //due to er reverse the loop;

        for (int i = ratio.length-1;i>=0;i--) {
            
            int idx=(int)ratio[i][0];
            
            if (capacity>=weight[idx]) {       // capacity>=wight
                
                capacity-=weight[idx];
                totalValue+=value[idx];

            }else{      // this mens only small cpacity is remaining and item have more weight so we ger that we reqire

                totalValue+=(ratio[i][1]*capacity); // formula to calculate divided wight value
                break;                  // coz now capacity is ended
            }
        }
        

        return totalValue;

    }

    public static void main(String[] args) {
        
        int weight[]={10,20,30};
        int value[]={60,100,120};

        System.out.println(maximumTotalValue(value, weight, 50));
    }
}
