package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    
    public static int chocletPiceWithMinCost(Integer[]verticleCC ,Integer[] horizontalCC) {
        
        // first we need to sort in desending order of cost like 3,2,1

        Arrays.sort(verticleCC,Collections.reverseOrder());// work eith only Integer Objects
        Arrays.sort(horizontalCC,Collections.reverseOrder());
        
                                                //verticleCC.sort(); sort asending order pf simple aary
        int cost=0;
        int vp=1,hp=1; //vertical horixontal pane to count the piceses

        int h=0,v=0;   //indexes


        while (v<verticleCC.length &&h<horizontalCC.length) {
            
            if (verticleCC[v]>=horizontalCC[h]) {  // cost of verticleCC[v] is grater then do cut over verticle plane 
                
                cost+=(verticleCC[v]*hp); // cutcost* pices we check horizontal pices while cut virtically
                vp++;                   //pices
                v++;                    //index

            }else{

                cost+=(horizontalCC[h]*vp);  //we check verticle pices while cut virtically
                hp++;
                h++;
            }

        }

        while (v<verticleCC.length) {   // for remining values
            
            cost+=(verticleCC[v]*hp); // cutcost* pices we check horizontal pices while cut virtically
                vp++;                   // vp pices
                v++;                    //index
        }
       

        while (h<horizontalCC.length) {
            
            cost+=(horizontalCC[h]*vp);  //we check verticle pices while cut virtically
            hp++;                       // hp pices
            h++;
        }
       return cost;

    }


    public static void main(String[] args) {    // if not understand consider a small example.. 2*2 matrix
        
        Integer vcost[]={2,1,3,1,4};
        Integer hcost[]={4,1,2};

        
        System.out.println(chocletPiceWithMinCost(vcost, hcost));
    }
}
