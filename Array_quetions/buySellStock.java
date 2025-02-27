package Array_quetions;

public class buySellStock{

    public static int profitCal(int prices[]) {  

        int maxProfit=0;
        int buyprice=prices[0];
       

        for(int i=1;i<prices.length;i++){       //{7,1,5,3,6,4}    profit=buyprice(low)-sellingprice(high)


           if(buyprice<prices[i]){
             
                int profit=prices[i]-buyprice;    //prices[i]---> selling price 
                maxProfit=Math.max(maxProfit,profit);

           }else{

                buyprice=prices[i];
           }
        }

        if(maxProfit<0){
            return 0;
        }

        return maxProfit;
    }

    public static void main(String args[]){

        int prices[]={7,1,5,3,6,4};

        System.out.println(profitCal(prices));
    }
}