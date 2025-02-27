package Heaps;

import Stringque.replaceCharInString;

public class HeapSort {   // refer AMG Diary also
    
    // for asending oerder sort we need to create max heap  Default
    // for Desendind oerder sort we need to create max heap Default

    /*
     * 1. Call non leaf node to hefify to create max/min heaft ( [(arr.length()-1/2) -> 0] are non leaf node)
     * 
     * 2. push largest element to last and elemnt it 
     * 
     *   -1> swap arr[0]<-->arr[n-1,-2,-3] , reverse for loop till 1 index
     *   -2> Call heafify() :- it do the larget elemt at 1st ie arr[0]-makes max heap again for -i.
     */
    
    public static void heapify(int arr[], int i, int size) {

        int leftC=2*i+1;
        int rightC=2*i+2;
        int maxIdx=i;     // if desending order then do min index

        if (leftC<size && arr[leftC]>arr[maxIdx]) {
            maxIdx=leftC;
        }

        if (rightC<size && arr[rightC]>arr[maxIdx]) {
            maxIdx=rightC;
        }
        
        if (maxIdx!=i) {
            
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;

            heapify(arr, maxIdx, size); // make the tree/ arrt maxheap
        }
    }

    public static void heapSort(int arr[]){  //{1,2,4,5,3}

        // 1>Call non leaf node to hefify to create max/min heaft ( [(arr.length()-1/2) -> 0] are non leaf node)

        int n=arr.length-1;        

        for (int i = n/2 ; i >=0 ; i--) {    //   {1,2,4}
                                             //      <-|
            heapify(arr, i, n);
        }

        //  2. push largest element to last and elemnt it   
        
        for (int i = n; i>=1; i--) {       // cant perform opration on sigle elemet
            
            int temp=arr[0]; //-1> swap arr[0]<-->arr[n-1,-2,-3] , reverse for loop till 1 index
            arr[0]=arr[i];
            arr[i]=temp;

            //   -2> Call heafify() :- it do the larget elemt at 1st ie arr[0]-makes max heap again for -i.

            heapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        
        int arr[]={1,2,4,5,3};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(" "+i);
        }

    }

}
