package Array_quetions;
public class arry_quetions{

    public static int largest_num(int numarry[]){

        int largest=0;

        for(int i=0;i<numarry.length;i++){

            if(numarry[i]>largest){

                largest=numarry[i];
            }
        }

        return largest;

    }

    public static int linear_search(int numarry[],int key){

        for(int i=0;i<numarry.length;i++){

            if(numarry[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static int binary_search(int numarry[],int key){

        int start=0;
        int end=numarry.length;
        int mid=0;

        while(start<=end){

            mid=(start+end)/2;

            if(numarry[mid]==key){

                return mid;
            }

            if(numarry[mid]<key){

                start=mid+1;
            }else{

                end=mid-1;
            }
        }
        return -1;
    }

    public static void reverse_arry (int numarry[]) {

        int start=0;
        int end=numarry.length-1;

        while(start<end){

            int temp=numarry[start];
            numarry[start]=numarry[end];
            numarry[end]=temp;

            start++;
            end--;
        }
    }

    public static void pair_print(int numarry[]) {
        
        for(int i=0;i<numarry.length;i++){
            for(int j=i+1;j<numarry.length;j++){

                System.out.print("("+numarry[i]+","+numarry[j]+") ");
            }
            System.out.println();
        }

        // formula to calculate number of pair is [n(n-1)/2] ex: [5(4)/2]=10 pairs
    }

    public static void subArry_print(int numarry[]) {
        
        for(int i=0;i<numarry.length;i++){
           
            for(int j=i;j<numarry.length;j++){

                for(int k=i;k<=j ;k++){

                     System.out.print(numarry[k]);
                } 
                System.out.print( " ");
            } 
            System.out.println();
        }

        // formula to calculate number of sub aary is [n(n+1)/2] ex: [5(6)/2]=15 pairs
    }

 
    public static void main(String args[]){

        int numbers[]={2,4,6,8,10};

        int key=12;

        // System.out.println(largest_num(numbers)); //Largest number in arry


        // int index=linear_search(numbers,key);   //Linear Search
        // int index=binary_search(numbers,key);   //Binary Search

        // if(index==-1)
        //      System.out.println("Element Not Found");
        // else
        //     System.out.println("Element At index No. :"+index);


        // reverse_arry(numbers);           //reverse arry

        // for(int i=0;i<numbers.length;i++)
        //     System.out.print(numbers[i]+" ");


        // pair_print(numbers);              //print pair

        subArry_print(numbers);

    }
}