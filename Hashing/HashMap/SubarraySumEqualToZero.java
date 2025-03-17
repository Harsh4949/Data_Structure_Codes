import java.util.HashMap;



public class SubarraySumEqualToZero {
    
    public static Boolean subarraySumEqualTozero(int []arr){

        int sum=0;
        HashMap<Integer,Boolean> sumMap= new  HashMap<>();

        for(int j=0;j<arr.length;j++){ 

            sum=sum+arr[j];    
            if (sum==0) {
                return true;
            }             
            
            if(sumMap.containsKey(sum)){
                return true ;
            } 
            
            sumMap.put(sum, true);
        }
                return false;
    }

    public static void main(String[] args) {
        
        int[] arr={10,2,-2,-20,10};

        System.out.println(" : "+subarraySumEqualTozero(arr));
    }
}
