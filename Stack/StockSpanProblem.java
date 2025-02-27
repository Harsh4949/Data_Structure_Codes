package Stack;

import java.util.*;


  //span :- how many days (back) was, stock price is equal or grater.
  // see the same logic of next grater element

public class StockSpanProblem {

  
    public static int[] findStockspan(int stock[]){   //O(n)

       int[] span =new int[stock.length];
       Stack<Integer> st = new Stack<>();   // we store indexes in the stack

       for(int i=0;i<stock.length;i++){

            while (!st.empty()&&stock[st.peek()]<=stock[i]) {
                st.pop();
            }

            if (st.empty()) {
                
                span[i]=i+1;            // if no one grater exits then itself if grater i+1 coz(index start with zero)
            }
            else{
                
                span[i]=i-st.peek();        // formula to find stack span form the  
                                            //current element index - previus grater elemnt = distace(days)
            }
                
            st.push(i);
       }

       return span;

    }

    public static void main(String[] args) {
        
        int stock[]={100,80,60,70,60,85,100};

        
        int span[]=findStockspan(stock);

        for (int val : span) {
            System.out.print(" "+val);
        }     
    }
}
