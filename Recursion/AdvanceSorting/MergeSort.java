package Recursion.AdvanceSorting;

public class MergeSort {        //O(n log n)  space O(n) reiqire more meory due to aary

    public static void printarry(int[] args) {
        
        for (int i=0;i<args.length;i++) 
            System.out.print(" "+args[i]);
        
    }

    public static int[] mergeSort(int[] arry,int si, int ei) {
        
        if (si==ei) {
            int baseElement[]={arry[si]};
            return baseElement;
        }
           
        
        int mid=si+(ei-si)/2;   //si+ei/2  same but stil that used to not memory overfolw

        int []left  = mergeSort(arry, si, mid);  //for left part
        int []right = mergeSort(arry, mid+1, ei); //for right part

        int []res=merge(left,right); 

        return res;
    }

    public static int[] merge(int left[],int right[]) {
        
        int temp[]=new int[left.length + right.length]; 

        int i=0;    //left arry traverser
        int j=0;    //right arry traverser
        int k=0;    //temp arry traverser

        while (i<left.length && j<right.length) {
            
            if (left[i]<right[j]) {
                temp[k]=left[i];
                i++; //k++;

            }else{
                temp[k]=right[j];
                j++; //k++;
            }

            k++; // instide of writing in both write onece
        }

        //for printig remainig elements in left and right part
        //for left

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
        
        int arr[]={6,2,9,8,5,4};

        printarry(arr);
        arr= mergeSort(arr, 0, arr.length-1);
        System.out.println();
        printarry(arr);

    }
}

/*              si  m     ei    
 *              6,2,9,8,5,4
 *          6,2,9          8,5,4
 *        6,2     9      8,5     4
 *       6    2    9    8    5     4   Divide
 * ---------------------------------------------------------------
 *         2,6   9        5,8   4       Conquer by sorting element use temprary element
 *          2,6,9          4,5,8   
 *             2,4,5,6,8,9 
 * 
 * here we crete the tempraroy arry to sort the element and store it at last in orignal arry like
 * 
 *              2,6,9 ->tempaarry left   take campareson form 1st to last index of both arry then store in ogrignal
 *              4,5,8 ->tempaarry Right
 *            2,4,5,6,9,8
 * 
 *              see in code
 */                        