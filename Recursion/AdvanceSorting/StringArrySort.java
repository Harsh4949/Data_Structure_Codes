package Recursion.AdvanceSorting;

public class StringArrySort {


    public static void printarry(String[] args) {
        
        for (int i=0;i<args.length;i++) 
            System.out.print(" "+args[i]);
        
    }

    public static String[] mergeSort(String[] arry,int si, int ei) {
        
        if (si==ei) {
            String baseElement[]={arry[si]};
            return baseElement;
        }
           
        
        int mid=si+(ei-si)/2;   //si+ei/2  same but stil that used to not memory overfolw

        String []left  = mergeSort(arry, si, mid);  //for left part
        String []right = mergeSort(arry, mid+1, ei); //for right part

        String []res=merge(left,right); 

        return res;
    }

    public static String[] merge(String left[],String right[]) {
        
        String temp[]=new String[left.length + right.length]; 

        int i=0;    //left arry traverser
        int j=0;    //right arry traverser
        int k=0;    //temp arry traverser

        while (i<left.length && j<right.length) {
            
            if (comparestr(left[i], right[j])) {

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


    public static boolean comparestr(String str1,String str2) {
      
      int i=str1.compareTo(str2);
     
      if (i<=0) {
         return true;
      }

      return false;
    }

    public static void main(String[] args) {
        
        String [] arr = { "sun", "earth", "mars", "mercury" } ;


        printarry(arr);
        arr= mergeSort(arr, 0, arr.length-1);
        System.out.println();
        printarry(arr);

    }
}

