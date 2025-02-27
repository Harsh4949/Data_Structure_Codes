package Recursion.AdvanceSorting;

public class InverseNumber {

    public static int count=0;
    
    public static int[] mergeSort(int []arr,int si,int ei){

        if (si==ei) {

            int []baseElement={arr[si]};
            return baseElement;
        }
        
        int mid =si+(ei-si)/2;

        int left[]=mergeSort(arr,si,mid);
        int right[]=mergeSort(arr,mid+1,ei);

        int res[]=merge(left,right);

        return res;
    }
    

    public static int[] merge(int left[],int[] right){

        int []temp= new int[left.length+right.length];

        int i=0;
        int j=0;
        int k =0;


        while (i<left.length &&j<right.length) {
            
            if (left[i]<right[j]) {
               
                temp[k]=left[i];
                i++;
            }
            else{
                temp[k]=right[j];
                j++;
                count+=(left.length-i);
            }
            k++;    
            
        }

        while (i<left.length) {
            temp[k++]=left[i++];
        }

        //for right

        while (j<right.length) {
            temp[k++]=right[j++];
        }

        return temp;
    }

    public static void main(String[] args) {
        
        int ary[]={2,4,1,3,5,7};
        ary=mergeSort(ary,0,ary.length-1);
        for (int i : ary) {
            System.out.print(" "+i);
        }

        System.out.println("\n Inverse Number : "+count);
    }
}

/*   l     r
     4,2    1   
     i      j
    (len(left))=2
    count == 3-2 =1  2-0=2
    
    1,4,2

 *    left      right
 *   1,2,4     3,5,7
 *     <-i     j
 * 
 * (len(left))=3
 *  count == 3-2 =1  
 * 
 * 
 * 
 * 
 * 
 * 
 */