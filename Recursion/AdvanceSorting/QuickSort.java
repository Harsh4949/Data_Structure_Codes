package Recursion.AdvanceSorting;

public class QuickSort { // Not needed more memory like merge sort so used when not more memory avalable
                         // Averrage Case O(n log n ) worst case O(n^2) and Space o(1)

    public static void printarry(int[] args) {

        for (int i=0;i<args.length;i++) 
            System.out.print(" "+args[i]);
    
    }

    public static void quickSort(int[] arr,int si, int ei) {
        
        if (si>=ei) {
            return;
        }
       
        int pidx=partation(arr, si, ei);
        
        quickSort(arr, si, pidx-1);
        quickSort(arr, pidx+1, ei);
    }

    public static int partation(int[] arr,int si,int ei) {
        
        int pivot=arr[ei];     //considered as last index pivot
        int i=si-1;

        for(int j=si;j<ei;j++){

            if (arr[j]<=pivot) {
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }

        i++;
        int temp1=pivot;
        arr[ei]=arr[i];
        arr[i]=temp1;

        return i;
    }

    public static void main(String[] args) {
        
        int arr[]={6,2,9,8,5,4,-2};

        printarry(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println();
        printarry(arr);
    }
    
}

/*
 *  in quick sort we use pivot number it may random,si,ei,mid 
 * 
 * here we use i and initiaize to -1 ie. si-1;
 * 
 *         i   si        ei&p 
 *  ex:-  -1 | 6,2,9,8,5,4
 * 
 * then we check the element less than pivot for that we use j 
 * if(arr[j]<pivot)
 *  i++
 *  swap(j,i);
 * 
 * at last also swap pivot 
 * 
 *         i   si        ei&p 
 *  ex:-  -1 | 6,2,9,8,5,4
 *             j->>>>>>>>>
 * 
 *            si        ei&p 
 *  ex:-     | 2,4,9,8,5,6
 *    leftpart<-i&p->rightpart
 * call the method for left and right   
 * 
 *                  
 *  ex:-      2,  4    9,8,5,6
 *                p    si   ei&p 
 * like that
 * 
 * 
 */