import java.util.HashMap;



public class SubarraySumEqualToK {
    
    public static int subarraySumEqualToK(int []arr,int K){

        int sum=0;
        int ans=0;

        HashMap<Integer,Integer> sumMap= new  HashMap<>();

        sumMap.put(0, 1);       // must to put if K is euqual to sum  of all elements in aary 
                                         //EX : {1,2,3} nad K=3 ,3-3=0 but not foun if not insert

        for(int j=0;j<arr.length;j++){  //O(n) {10,2,-2,-20,10}

            sum=sum+arr[j];                   // 10 , 12, 10, -10 0
            
            if (sumMap.containsKey(sum-K)) {  // 20 22 20 0 10 

                ans+=sumMap.get(sum-K);  // ans++; aslo considered... see logic in image
                //ans++;
            }

                sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1); // 0:3 ,10 : 2 , 12:1 ,
        }


        return ans;  //3
    }

    public static void main(String[] args) {
        
        int[] arr={10,2,-2,-20,10}; 
        int[] arr2={10,7,4,5,20}; 

        System.out.println(" Number Subaays With Sum -10 : "+subarraySumEqualToK(arr,-10 ));
        System.out.println(" Number Subaays With Sum -10 : "+subarraySumEqualToK(arr2,9 ));
    }
}
