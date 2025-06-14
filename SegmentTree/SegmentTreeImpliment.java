package SegmentTree;

public class SegmentTreeImpliment {
    
    public static int stree[];

    public static void init(int  n) {
        stree=  new int[n*4];       // as per mentioned image "D:\Programming\vscodeProgram\SegmentTree\SegmentTreeLogic.jpg"
    }
    
    public static int buildST(int arr[],int i,int st,int end) {
        
        if (st==end) {  // only one elemnt is remaining  here we handle signle NODE
            stree[i]=arr[st];
            return arr[st];
        }

        // do dived into two part like merge sort nad use heap logic to go left and right

        int mid=(st+end)/2;
        int left = buildST(arr, 2*i+1, st, mid);        // if go left then 2*i+1
        int right = buildST(arr, 2*i+2, mid+1, end);  // if go right then 2*i+2
       
        //stree[i]=stree[2*i+1]+stree[2*i+2];             //aslo correct

        return stree[i]=left+right;     // NOW WE handle two Node Addition
    }

    public static void printST(int[] args) {

        System.out.println();
        for (int i : args) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int arr[]={1,2,3,4,5,6,7,8};
        int n= arr.length;

        init(n);
        System.out.println(buildST(arr, 0, 0, n-1));

        printST(arr);
        printST(stree);
    }
}
