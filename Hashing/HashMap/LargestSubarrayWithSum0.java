import java.util.HashMap;


public class LargestSubarrayWithSum0 {

    public static int largetSubArrSum0(int []arr){

        int sum=0;
        int len=0;
        HashMap<Integer,Integer> sumMap= new  HashMap<>();

        for(int j=0;j<arr.length;j++){  //O(n)

            sum=sum+arr[j];
            
            if (sumMap.containsKey(sum)) {   // use sum as key, index ans value, if sum it exits
                                            // then chek the number of value present between j(cuuent value) 
                                            //and exiting sum(i.e index of previus sum sumMap.get(sum)) becoz they not contributing in sum 
                                            // due we get same sum and cheking if (sumMap.containsKey(sum))

              len=Math.max(len,j-sumMap.get(sum));

            }else{               // add if uniqe sum is got

                sumMap.put(sum, j);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        
        int[] arr={15,-2,2,-8,1,7,10};

        System.out.println(" Largest Subarray With Sum 0 : "+largetSubArrSum0(arr));
    }
}
