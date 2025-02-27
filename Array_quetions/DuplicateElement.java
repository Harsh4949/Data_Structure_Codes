package Array_quetions;

import java.util.HashSet;

public class DuplicateElement{

    public static boolean duplicateval(int numarry[]) {

        
        // for(int i=0;i<numarry.length-1;i++){         //worst case O(n^2)

        //     for(int j=i+1;j<numarry.length;j++){

        //         if(numarry[i]==numarry[j]){

        //             return true;
        //         }
        //     }
        // }

        // return false;

        HashSet <Integer> set= new HashSet<Integer>();       //best case O(n)


        for(int i=0;i<numarry.length;i++){ 

            if(set.contains(numarry[i])){
                return true;
            }else{
                set.add(numarry[i]);
            }
        }

        return false;
    }
    
    public static void main(String args[]){

        int numbers[]={1, 1, 1, 3, 3, 4, 4, 2};

        System.out.println(duplicateval(numbers));

    }
}