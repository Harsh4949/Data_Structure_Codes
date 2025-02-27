package Stack;
import java.util.Stack;

public class NextGreaterElement {
    
    public static int[] nextGreaterElement(int arr[]){  //O(n)

        int []nextgrater=new int[arr.length];

        Stack<Integer> st = new Stack<>();      //**** */ we store indexes in stack remainmer****

        // first we need to reverse traverse the given array for find next element

        for(int i=arr.length-1;i>=0;i--){

            while (!st.empty() &&  arr[st.peek()]<=arr[i]){     // remove element less than curent element
                st.pop();
            }

            if (st.empty()) {               // if stack goes empty then add -1
                nextgrater[i]=-1;
            }
            else{
               nextgrater[i]=arr[st.peek()];     // otherwisw the first grater element than cuurnt
                                                // elemnt remain on top
            }

            st.push(i);                        //push(i) at last coz last element have
                                               // not next grater elememt it need -1
        }


        return nextgrater;
    }

    public static void main(String[] args) {
        
        int arr[]={2,0,9,5,3};

        int sol[]=nextGreaterElement(arr);

        for (int val : sol) {
            System.out.print(" "+val);
        }
    }
}

/*
 * Dry run :           2,0,9,5,3
 *  
 *  expected output :  9 9-1-1-1
 * 
 * output  9 9 -1 -1 -1: 
 * 
 * similer quetions like : Next Right grater (current it is)
 *                         Next left grater(reverse for loop)
 *                       * Next Right smaller
 *                       * Next left smaller
 * 
 */