package Recursion.AdvanceSorting;

public class RotatedSortedArray { // see the image for better understnading and draw infornt of you.

    public static int search(int[] arr, int tar,int si, int ei) {
        
        int mid =si+(ei-si)/2;

        if (arr[mid]==tar) 
            return mid;
        
        //check wheter it presnet on L1 Or L2 (L-> Line)

        if (arr[si]<=arr[mid]) {                    //L2
                                                    //Now check whether it present on left or right of mid
            if (arr[si]<=tar && tar<=arr[mid])      // check left
                return search(arr, tar, si, mid-1);
            
            else                                    //else right
                return search(arr, tar, mid+1, ei);        // mid are alrady checked

        }
        else{                                       //L2

            if (arr[mid]<=tar &&  tar<=arr[ei])                        //check right
                    return search(arr, tar, mid+1, ei);

            else 
                return search(arr, tar, si, mid-1);                 //left
            
        }

    }

    public static void main(String[] args) {
        
        int ary[]={4,5,6,7,0,1,2,3};
        int target=0;
        System.out.println(search(ary, target, 0, ary.length-1 ));
    }
}



//using loop 

/*

 public static int search(int[] arr,int tar) {
    
      int si=0;
      int ei=arr.length-1; 
      
      while (true) {

        int mid =si+(ei-si)/2;

        if (arr[mid]==tar) {
          return mid;
        }

        if (arr[si]<=arr[mid]) {
           
          if (arr[si]<=tar&&tar<=arr[mid]) 
                              ei=mid-1;          
          else 
            si=mid+1;

        }else{

          if(arr[mid]<=tar&&tar<=arr[ei])
                    si=mid+1;
          else
              ei=mid-1;
        
        }
      }
 
 */
