package GreedyAlgorithms;

public class IndianCoins {
    
    public static int findNoOfNotes(int currency[],int valueR){
        
        int noNotes=0;

        // we need to reverse the loop to add like this 121=(100+20+1)
        int i =currency.length-1;

        while (i>=0 &&valueR!=0) 
        {
            if (currency[i]<=valueR) {
               
                if(currency[i]<=valueR){
                    valueR-=currency[i];
                   // System.out.print(currency[i]+"+");  // or add in arrayList
                    noNotes++;

                }else
                    continue;
            }
            else
                i--;
            
        }

        System.out.print("\t Notes : ");

        return noNotes;
    }

    public static void main(String[] args) {
        
        int denominations[]={1,2,5,10,20,50,100,500,2000};

        System.out.println(findNoOfNotes(denominations,121));
        System.out.println(findNoOfNotes(denominations,590));
        System.out.println(findNoOfNotes(denominations,10045));
        System.out.println(findNoOfNotes(denominations,12345));
        System.out.println(findNoOfNotes(denominations,1059));
    }
}
