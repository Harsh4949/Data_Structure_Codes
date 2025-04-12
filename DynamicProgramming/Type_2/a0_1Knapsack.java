package DynamicProgramming.Type_2;

public class a0_1Knapsack {
    
    public static int maxProfit(int val[],int wt[],int W,int cur){

        if (cur==0 || W==0) {
            return 0;
        }
        
       // int finalans;
        if (wt[cur-1]<=W) {

        // where we include the cur weight and value
            int profit1=val[cur-1]+maxProfit(val, wt, W-wt[cur-1], cur-1); // cur point to form the last to 1st elemnts in arry.
                        //add then value of itself while returning.. imp
            // // where we exlude the cur weight and value see dry run for understnding...

            int profit2=maxProfit(val, wt, W, cur-1); // we does not include weight and value

            return Math.max(profit1, profit2);

        }else{// if bag if full... then exclude

            return maxProfit(val, wt, W, cur-1);
        }

       // return finalans;
    }

    public static void main(String[] args) {    // there are 2 possiblity of evry weight/product were it include or exclude so we use two recusion call.
        
        int val[]={15,14,10,45,30}; // cost of each weight
        int wt[]={2,5,1,3,4};      // weight
        int W=7;        // Max capacity of Bag


        System.out.println(maxProfit(val, wt, W, val.length));

    }
}
