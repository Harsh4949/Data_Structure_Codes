package SegmentTree;

public class Max_MinST {

    public static int stree[];

    public static void init(int n) {
        stree= new int[n*4];   // see the privius logic
    }
    
    public static void print(int[] args) {
        
        for (int string : args) {
            System.out.print(" "+string);
        }
        System.out.println();
    }

    public static int buildMaxST(int arr[],int i, int st,int end){

        if (st==end) {  //base case //leaf Node reach
            stree[i]=arr[st]; // store in leaf node
            return arr[st];
        }

        int mid=(st+end)/2;

        int left=buildMaxST(arr, 2*i+1, st, mid);
        int right=buildMaxST(arr, 2*i+2, mid+1, end);

        return stree[i]=Math.max(left, right);   // max between Two Node 
    } 

    public static int getMaxUtil(int i, int si,int sj,int qi,int qj) {
        
        if(sj<qi ||qj<si){        // non-overlap
             return Integer.MIN_VALUE;
        }
        else if (si<=qi &&sj<=qj) {  // overlap then send value for comparision
            return stree[i];
        }
        else{       // partial Overlap -> Divide it

            int mid=(si+sj)/2;
            int left=getMaxUtil(2*i+1, si, mid, qi, qj);
            int right=getMaxUtil(2*i+2, mid+1, sj, qi, qj);

            return Math.max(left, right);
        }
    }

    
    public static int getMax(int[] arr,int qi,int qj) {
        
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static void main(String[] args) {
        
       int arr[]={6,8,-1,2,17,1,3,2,4};
        int n= arr.length;

        init(n);
        System.out.println(buildMaxST(arr, 0, 0, n-1));
        print(arr);
        print(stree);

        System.out.println(getMax(arr, 3, 3));

    }
}