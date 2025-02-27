package Array_quetions.sortingAlgoNQue;
import java.util.*;

public class BasicSorting {

    public static void bubbleSort(int numarry[]) {
        
        for(int turns=1;turns<=numarry.length-1;turns++){
            
            int swap=0;

            for(int j=0;j<numarry.length-turns;j++){

                if(numarry[j]>numarry[j+1]){

                    int temp=numarry[j];
                    numarry[j]=numarry[j+1];
                    numarry[j+1]=temp;
                    swap++;
                }

               // System.out.print(" "+numarry[j]);  //see How works.
            }

            if(swap==0){        //this is for if array is alrady sorted 
                break;          //if no one element is swaped(during one turn/pass) then mens arrry is sorted. 
            }                   //then exit the loop.

          //  System.out.println();
        }

    }

    public static void selectionSoort(int numarry[]) {

       // int minval ;       //1st find minimun value form arry 
        
        for(int i=0;i<numarry.length-1;i++){

        //    minval=i;                             
            for(int j=i+1;j<numarry.length;j++){    //j=i+i denote unsoterd array ,i is sorted array

                if(numarry[i]>numarry[j]){
                   // minval=j;
                    int temp=numarry[i];
                    numarry[i]=numarry[j];
                    numarry[j]=temp;
                }

               // System.out.print(" "+numarry[j]); //see itrations
            }

            //System.out.println();
        }
    }

    public static void insertionSort(int numarry[]) {    //see again and again

            //{1,2,3,5,4}
            //   c p

        for(int i=1;i<numarry.length;i++){
            int pre=i-1;  
            int cur=numarry[i]; 
            while(pre>=0 && numarry[pre]>cur){

                numarry[pre+1]=numarry[pre];
                pre--;
            }

            numarry[pre+1]=cur;
        }
        
    }

    public static void countingSort(int numarry[]) {

        int largest=numarry[0];
        for(int i=1;i<numarry.length;i++){

            largest=Math.max(largest, numarry[i]);
        }

        int count[]=new int[largest+1];

        for(int i=0;i<numarry.length;i++){

            count[numarry[i]]++;
        }

        int j=0;
        for(int i=0;i<numarry.length;i++){

            while (count[i]>0) {
               numarry[j]=i;
               count[i]--;
               j++;
            }
        }

    }

    public static void printArry(int []arry) {

        System.out.println();
  
        for(int i=0;i<arry.length;i++){
            System.out.print(" "+arry[i]);
        }
    }

    public static void printArryInteger(Integer []arry) {

        System.out.println();
  
        for(int i=0;i<arry.length;i++){
            System.out.print(" "+arry[i]);
        }
    }

    public static void main(String[] args) {

        int numbers[]={1,4,1,3,2,4,3,7};
        //Integer numbers2[]={1,2,5,3,4};

        //bubbleSort(numbers);

        //selectionSoort(numbers);

        // insertionSort(numbers);

        countingSort(numbers);
        printArry(numbers);

        //Arrays.sort(numbers);
        //Arrays.sort(numbers,0,3);

        // Arrays.sort(numbers2,Collections.reverseOrder());
        // Arrays.sort(numbers2,1,3,Collections.reverseOrder());
        // printArryInteger(numbers2);

        
        
    }
    
}
