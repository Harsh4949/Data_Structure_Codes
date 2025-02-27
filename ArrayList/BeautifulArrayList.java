package ArrayList;

import java.util.ArrayList;

public class BeautifulArrayList {
    
    public static ArrayList<Integer> findBeautifulArr(int n){
        
        ArrayList<Integer> anslist = new ArrayList<>();
        anslist.add(1);     //by default size one then it itself sorted

        System.out.println(anslist.size());

        for(int i=2;i<=n;i++){

            ArrayList<Integer> temp = new ArrayList<>();

            //first we need to insert odd numbers as given in list <= n

            for (Integer j : anslist) {

                if (j*2-1<=n) {             //ex : 2*2-1=3 like that 

                    temp.add(j*2-1);
                }
            }

            //then we need to insert Even numbers as given in list <= n

            for (Integer k : anslist) {
                
                if (k*2 <=n) {          //2*2= like that
                    
                    temp.add(k*2);
                }
            }

            anslist=temp;
        }

        return anslist;
    }

    public static void usingRecursionDivideAndConqure(int start,int inc,ArrayList<Integer> ans,int n) {
        
        //base case 

        if (start+inc>n) {

            ans.add(start);
            return ;
        }

        //recursion

        usingRecursionDivideAndConqure(start, inc*2, ans, n);       // for even nums
        usingRecursionDivideAndConqure(start+inc, inc*2, ans, n);         // for odd nums

    }



    public static void main(String[] args) {
        
        System.out.println(findBeautifulArr(4));

        ArrayList<Integer> temp = new ArrayList<>();
        usingRecursionDivideAndConqure(1,1,temp, 3 );

        System.out.println(temp);
    }
}


    /*
     *
     * start =1 ,inc=1
     * 
     *
     *   Here we get the 
     *      
     *         add(1)
     *  {1,2} {1,4} <----usingRecursionDivideAndConqure(start, inc*2, ans, n);  
     *   |
     *  {3,4}       <-----usingRecursionDivideAndConqure(start+inc, inc*2, ans, n);  
     *        |
     *  {2,2}{2,4} <-----{usingRecursionDivideAndConqure(start+inc, inc*2, ans, n); 
     * 
     * 
     * 
     *      if (start+inc>n) {
                ans.add(start);     ---> {1,3,2}
                return ;
            }
     *       
     */
