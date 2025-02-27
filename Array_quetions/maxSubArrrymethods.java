package Array_quetions;
public class maxSubArrrymethods{

    public static void subArry_print(int numarry[]) {
        
        for(int i=0;i<numarry.length;i++){

            for(int j=i;j<numarry.length;j++){

                for(int k=i;k<=j;k++){
                    System.out.print("["+numarry[k]+"]");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void max_sub_arry(int numarry[]) {     //worst O(n^3) brust force
        
        int maxsum=0;

        for(int i=0;i<numarry.length;i++){
            for(int j=i;j<numarry.length;j++){
                int cursum=0;

                for(int k=i;k<=j;k++){

                    cursum+=numarry[k];                    
                }

                System.out.print("["+cursum+"] ");

                if(cursum>maxsum){
                    maxsum=cursum;
                }
            }
            System.out.println();
        }
        System.out.println("Max subarry sum is : "+maxsum);
    }

    public static void prifix_max_sub_arry(int numarry[]) {    //Average O(n^2) Prifix sum
        
        int maxsum=0;
        int prifixArry[]=new int[numarry.length];
        int cursum=0;
        

        prifixArry[0]=numarry[0];

        for(int i=1;i<numarry.length;i++){

            prifixArry[i]=prifixArry[i-1]+numarry[i];
        }

        for(int i=0;i<numarry.length;i++){
            for(int j=i;j<numarry.length;j++){
   
                cursum=i==0?prifixArry[j]:prifixArry[j]-prifixArry[i-1];

                if(cursum>maxsum){
                    maxsum=cursum;
                }
                System.out.print("["+cursum+"] ");

            }
            System.out.println();
        }
        System.out.println("\nMax subarry sum is : "+maxsum);
    }

    public static void kadane_max_sub_arry(int numarry[]) {     //Best O(n^1) kadane algoritham
     
        int maxsum=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<numarry.length;i++){

            sum+=numarry[i];

            if(sum>maxsum){

                maxsum=sum;
            }

            if(sum<0){
                sum=0;
            }
        }

        System.out.println("Max subarry sum is : "+maxsum);
    }

    public static void main(String args[]){

        int numbers[]={-1,-2,6,1,3};

         subArry_print(numbers);

        // max_sub_arry(numbers); //worst solution to find max addtion of sub arry

        //prifix_max_sub_arry(numbers); // //Average solution to find max addtion of sub arry

        kadane_max_sub_arry(numbers);   //Best solution to find max addtion of sub arry
 
    }
}