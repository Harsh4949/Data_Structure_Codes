package Backtracking;

public class SimpleArrayBacktraching {

    public static void arryBacktrack(int[] arr,int idx,int val) {
        
        if (idx==arr.length) {

            printArray(arr);
            return;
        }
           

        arr[idx]=val;

        arryBacktrack(arr, idx+1, val+1);

        arr[idx]-=2;
    }


    public static void printArray(int[] args) {
        
        for(int i=0;i<args.length;i++)
                 System.out.print(" "+args[i]);
    }

    public static void main(String[] args) {
        
        int arr[]=new int[5];

        arryBacktrack(arr, 0, 1);

        System.out.println();
        printArray(arr);


    }
    
}
