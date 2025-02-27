package Stack;

import java.util.Stack;

public class MaxRectangularAreaHistogram {
    
    public static int maxAreaHistogram(int []height){  //O(3n)-> O(n)

        int maxarea=0;
        Stack<Integer>s=new Stack<>();

        int[] leftNextSmllest=new int[height.length];
        int[] rightNextSmllest=new int[height.length];

        for(int i=height.length-1;i>=0;i--){

                                        //3 >=2
            while (!s.empty()&&height[s.peek()]>=height[i]) {
                s.pop();
            }

            if (s.empty()) {
                rightNextSmllest[i]=height.length;

            }else{
                rightNextSmllest[i]=s.peek();
            }

            s.push(i);
        }

    
        s=new Stack<>();

        for(int i=0;i<height.length;i++){

                //3 >=2
            while (!s.empty()&&height[s.peek()]>=height[i]) {
                s.pop();
            }

            if (s.empty()) {
                leftNextSmllest[i]=-1;

            }else{
                leftNextSmllest[i]=s.peek();
            }

            s.push(i);

        }
            

        for(int i=0;i<height.length;i++){

            int curval;
            int h=height[i];
            int w=rightNextSmllest[i]-leftNextSmllest[i]-1;

            curval=h*w;
            
            maxarea=Math.max(curval, maxarea);
        }
    
        return maxarea;
    }
        

    public static void main(String[] args) {
        
        int height[]={2,1,5,6,2,3};

        System.out.println(maxAreaHistogram(height));

    }
}
