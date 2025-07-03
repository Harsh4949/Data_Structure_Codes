package SegmentTree;

public class SegmentTreeImpliment {
    
    public static int stree[];

    public static void init(int  n) {
        stree=  new int[n*4];       // as per mentioned image "D:\Programming\vscodeProgram\SegmentTree\SegmentTreeLogic.jpg"
    }
    
    public static int buildST(int arr[],int i,int st,int end) { // O(n)
        
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

    public static int getSumUtil(int i,int si,int sj,int qi,int qj) {  // see the image for understnading "D:\Programming\vscodeProgram\SegmentTree\STQueryGetSum.jpg"
        
        if (qj<si ||sj<qi) {      //Case 1 if query Range not Overlap
            return 0;  // Not include it

        }
        else if(qi<=si && sj<=qj){   //Case 2 if query Range Overlap 

            return stree[i]; // add the node range(i.e si-sj)
        }
        else{   //parovetial Overlap
            // divide it

            int mid=(si+sj)/2;

            int left=getSumUtil(2*i+1, si, mid, qi, qj);// left tree call
            int right=getSumUtil(2*i+2, mid+1, sj, qi, qj);  // right tree call
            
            return left+right;
        }
    }

    public static int getSum(int[] arr,int qi ,int qj) { //log n
        
        int n= arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil(int i,int si,int sj,int idx,int diff) {
        
        if (idx<si ||sj<idx) {     // if idx does not lies Between Si-Sj // See Image StUpadateLogic.png
            return;                         //Does not inclued 
        }
       
        if (si==sj) {
            stree[i]+=diff;
            return;
        }

        // if(si!=sj) it is also considered.
        int mid=(si+sj)/2;
        updateUtil(2*i+1, si, mid, idx, diff);
        updateUtil(2*i+2, mid+1, sj, idx, diff);

        stree[i]+=diff;
    }

    public static void upadte(int[] arr,int idx,int newVal) {
        
        int diff= newVal-arr[idx]; // oldVal-newVal = Differce 
        arr[idx]=newVal;
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, diff);
        System.out.println("Update Done Suscess fully");
        printST(arr);
       
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

        //System.out.println(getSum(arr, 0, 3));
        System.out.println(getSum(arr, 2, 5));  // Dry run it for undertanding using STConstructionLogic.jpg Image

        upadte(arr, 0, 9);
        printST(stree);
        System.out.println(getSum(arr, 0, 3));
    }
}


// think about the