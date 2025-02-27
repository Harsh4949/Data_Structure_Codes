package Stack;

import java.util.*;

public class TrappingRainwater {
    
    public static int countTrappingRainwater(int[] height){

        int maxwater=0;

        Stack<Integer> s =new Stack<>();

        for(int right=0;right<height.length;right++){   //313 dry run 

            while (!s.empty()&&height[s.peek()]<=height[right]) {
                
                int smallHeight=s.pop();// middle height current node consider

                if (s.isEmpty()) {      // no need to calculate water ccoz its height is very high
                    break;
                }

                int left=s.peek();  

                int h=Math.min(height[right], height[left])-height[smallHeight];//imp

                int w=right-s.peek()-1; // take example of (6-3)-1 = 2 we need to consider between two bar value

                maxwater+=h*w;
            }

            s.push(right);
        }

        return maxwater;
    }

    public static void main(String[] args) {
        
        int []height={7,0,4,2,5,0,6,4,0,5};

        System.out.println(countTrappingRainwater(height));
    }
}
